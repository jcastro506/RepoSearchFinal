package com.example.reposearchbystars.presentation.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reposearchbystars.domain.RepoItem
import com.example.reposearchbystars.domain.repository.RepoRepository
import com.example.reposearchbystars.presentation.state.RepoItemState
import com.example.reposearchbystars.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository : RepoRepository
) : ViewModel() {


    //live data response for view model test class
    val response = MutableLiveData<Boolean>(false)


    var repos = mutableStateOf<List<RepoItem>>(emptyList())

    private var _searchQuery = mutableStateOf("")
    var searchQuery : State<String> = _searchQuery

    private var _state = mutableStateOf(RepoItemState())
    var state : State<RepoItemState> = _state

    private var searchJob:Job? = null

    init {
        onSearch(searchQuery.value)
    }


    fun onSearch(query:String) {
        if(query.isEmpty()){return}
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            invoke(query)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                allRepos = result.data ?: emptyList(),
                                isLoading = false
                            )
                            if(result.data!!.size > 3) {
                                repos.value = result.data.sortedByDescending { it -> it.stargazersCount }
                                    .slice(0..2)
                            } else {
                                repos.value = result.data.sortedByDescending { it -> it.stargazersCount }
                            }
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                allRepos = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                allRepos = result.data ?: emptyList(),
                                isLoading = false
                            )

                        }
                    }
                }.launchIn(this)
        }
    }


    fun invoke(org : String) : Flow<Resource<List<RepoItem>>> = flow {

        try {
            emit(Resource.Loading<List<RepoItem>>())
            val repos = repository.getTopRepos(org)
            emit(Resource.Success<List<RepoItem>>(repos))
            response.value=true
        } catch (e:HttpException){
            response.value=false
            emit(Resource.Error<List<RepoItem>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            response.value=false
            emit(Resource.Error<List<RepoItem>>("Couldn't reach the server. Check internet."))
        }
    }


}