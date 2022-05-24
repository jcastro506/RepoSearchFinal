package com.example.reposearchbystars.data.remote

import com.example.reposearchbystars.domain.RepoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {

    @GET("orgs/{org}/repos")
    suspend fun getTopRepos(@Path("org") org : String) : List<RepoItem>

}