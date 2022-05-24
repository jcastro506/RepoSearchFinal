package com.example.reposearchbystars

import android.os.SystemClock
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.espresso.Espresso
import com.example.reposearchbystars.di.RepoModule
import com.example.reposearchbystars.presentation.composable.MainScreen
import com.example.reposearchbystars.presentation.composable.WebPageScreen
import com.example.reposearchbystars.util.Common
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test



//uninstall module, this will uninstall RepoModule,
// it means it will not use RepoModule which is main module of the application for hilt
//It will only use test module
@UninstallModules(RepoModule::class)
@HiltAndroidTest
class MainScreenTest{


    //hilt rule to add hilt dependency injection in test process
    //order define which rule should init first
    @get:Rule(order=0)
    val hiltRule=HiltAndroidRule(this)



    @get:Rule(order = 1)
    val composeRule= createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){


        hiltRule.inject()

        //settingUp screens before we can test
        composeRule.setContent {
            val navController= rememberNavController()

            NavHost(navController = navController, startDestination ="main_screen" ){

                composable("main_screen"){
                   MainScreen(navController)
                }

                composable("webView") { navBackStack ->

                    WebPageScreen( "https://github.com/freeCodeCamp/devdocs")
                }
            }

        }
    }




    //test, perform search, click item and go to webview screen to load repo
    @Test
      fun test_search_and_repo_item_click(){

        // Here we are using tags which belongs to views
        // and on the basis of those tags we are performing actions on the views

        //input text in search field
        composeRule.onNodeWithTag(Common.SEARCH_FIELD_TAG).performTextInput("freeCodeCamp")

        //delay for 1 second to load data
        Thread.sleep(1000)
        //check if repo item is displayed
        composeRule.onNodeWithTag(Common.REPO_ITEM_TAG).assertIsDisplayed()
        composeRule.onNodeWithTag(Common.REPO_ITEM_TAG).performClick()
        //Thread.sleep(1000)
        composeRule.onNodeWithTag(Common.WEB_VIEW_TAG).assertIsDisplayed()
        //back press test
        Thread.sleep(3000)
        Espresso.pressBack()
        Thread.sleep(3000)


    }
}