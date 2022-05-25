package com.example.reposearchbystars

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.reposearchbystars.data.repository.FakeRepository
import com.example.reposearchbystars.presentation.viewModel.MainViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.*



@ExperimentalCoroutinesApi
class MainViewModelTest {


    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()


    //rule to enable coroutines in test mode
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()


    private lateinit var repository: FakeRepository
    private lateinit var mainViewModel: MainViewModel




    //function to run code before test
    @Before
    fun setUp() {

        repository = FakeRepository(null)
        mainViewModel= MainViewModel(repository)

    }


    //Test to verify success response
    @Test
    fun `Success state works`() = runTest {


        mainViewModel.onSearch("org")

        //delay for sometime to complete live data process
        delay(1000)


        //mainViewModel.response.value is declared in MainViewModel class
        //and its value changed to true or false according to response
        Assert.assertTrue(mainViewModel.response.value==true)



    }


    //Test to verify error response
    @Test
    fun `Failure state works`() = runTest {

        //setting search query empty will return error response
        mainViewModel.onSearch("")

        //delay for sometime to complete live data process
        delay(3000)
        Assert.assertTrue(mainViewModel.response.value==false)

    }

    @After
    fun tearDown() {

    }
}

