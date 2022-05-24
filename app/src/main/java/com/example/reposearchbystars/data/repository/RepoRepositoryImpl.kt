package com.example.reposearchbystars.data.repository

import com.example.reposearchbystars.data.remote.RetrofitApi
import com.example.reposearchbystars.domain.RepoItem
import com.example.reposearchbystars.domain.repository.RepoRepository
import javax.inject.Inject


class RepoRepositoryImpl @Inject constructor(
    private val api : RetrofitApi
) : RepoRepository {

    override suspend fun getTopRepos(org: String): List<RepoItem> {
        return api.getTopRepos(org)
    }
}