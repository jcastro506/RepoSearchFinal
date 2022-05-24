package com.example.reposearchbystars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reposearchbystars.domain.RepoItem
import com.example.reposearchbystars.presentation.composable.MainScreen
import com.example.reposearchbystars.presentation.composable.RepoItemList
import com.example.reposearchbystars.presentation.composable.WebPageScreen
import com.example.reposearchbystars.presentation.viewModel.MainViewModel
import com.example.reposearchbystars.ui.theme.RepoSearchByStarsTheme
import com.example.reposearchbystars.util.requiredArg
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepoSearchByStarsTheme {
                val viewModel:MainViewModel by viewModels()
                val state = viewModel.state
                val scaffoldState = rememberScaffoldState()

                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main_screen") {
                        composable("main_screen") {
                            MainScreen(navController = navController, viewModel = viewModel)
                        }

                        composable("webView") { navBackStack ->

                            val repo = navBackStack.requiredArg<RepoItem>("repo")
                            repo.htmlUrl?.let { WebPageScreen(it) }


                        }
                    }
                }
            }
        }
    }
}

