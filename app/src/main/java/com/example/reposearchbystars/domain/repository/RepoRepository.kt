package com.example.reposearchbystars.domain.repository

import com.example.reposearchbystars.domain.RepoItem

interface RepoRepository {

    suspend fun getTopRepos(org:String) : List<RepoItem>

}