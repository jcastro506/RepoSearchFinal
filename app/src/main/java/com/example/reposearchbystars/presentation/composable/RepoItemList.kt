package com.example.reposearchbystars.presentation.composable

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import com.example.reposearchbystars.domain.RepoItem
import com.example.reposearchbystars.presentation.viewModel.MainViewModel
import com.example.reposearchbystars.util.Common
import com.example.reposearchbystars.util.myNavigate


@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel=hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {
        Box(modifier = Modifier.background(Color.LightGray)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TextField(value = viewModel.searchQuery.value,
                    onValueChange = viewModel::onSearch, modifier = Modifier.fillMaxWidth()
                        .background(Color.White).testTag(Common.SEARCH_FIELD_TAG),
                    placeholder = {
                        Text(text = "Search")
                    })
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(viewModel.repos.value) { repo ->
                        RepoItemList(repoItem = repo, navController)
                    }
                }
            }
        }
    }
}



@Composable
fun RepoItemList(
   repoItem : RepoItem,
   navController: NavController
) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(repoItem.htmlUrl))}
    Column(modifier = Modifier) {
        Text(text = repoItem.name!!, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black,
            modifier = Modifier.clickable {
                //context.startActivity(intent)
                navController.myNavigate("webView", "repo" to repoItem)

            }.testTag(Common.REPO_ITEM_TAG))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "${repoItem.stargazersCount.toString()} stars", fontSize = 20.sp, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = if(repoItem.description.toString() === "null"){
                                                                  "no description."
                                                                  } else {repoItem.description.toString()}, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp
        )
    }
}


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebPageScreen(urlToRender: String) {

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(urlToRender)
        }
    }, update = {
        it.loadUrl(urlToRender)
    },modifier = Modifier.testTag(Common.WEB_VIEW_TAG))
}