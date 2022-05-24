package com.example.reposearchbystars.presentation.state

import com.example.reposearchbystars.domain.RepoItem
import com.example.reposearchbystars.util.Resource

data class RepoItemState(
    val allRepos : List<RepoItem> = emptyList(),
    val isLoading: Boolean = false
)