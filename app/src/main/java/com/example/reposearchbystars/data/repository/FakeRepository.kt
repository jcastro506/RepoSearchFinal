package com.example.reposearchbystars.data.repository


import com.example.reposearchbystars.data.remote.RetrofitApi
import com.example.reposearchbystars.domain.RepoItem
import com.example.reposearchbystars.domain.repository.RepoRepository
import com.example.reposearchbystars.util.MockResponseFileReader
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type



//Repository to load data for test purpose
class FakeRepository(private val apiInterface: RetrofitApi?) : RepoRepository{


    override suspend fun getTopRepos(query: String): List<RepoItem> {


        //if search query is not empty then it will return success response
        // otherwise it will return error response
        //both files are places within the application in resources folder
        var json:String = if(query.isNotEmpty()) {
            //this will load a local file named api_response
            MockResponseFileReader("api_response.json").content
        }else {
            MockResponseFileReader("error.json").content
        }

        //converting json file to list
        var type:Type = object : TypeToken<List<RepoItem?>?>() {}.type

        val gson = Gson()
        return gson.fromJson(json, type)
    }



}