package com.example.reposearchbystars.util

import android.os.Parcelable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

fun NavController.myNavigate(route1: String, vararg args: Pair<String, Parcelable>) {
    navigate(route1)
    
    requireNotNull(currentBackStackEntry?.arguments).apply {
        args.forEach { (key: String, arg: Parcelable) ->
            putParcelable(key, arg)
        }
    }
}

inline fun <reified T : Parcelable> NavBackStackEntry.requiredArg(key: String): T {
    return requireNotNull(arguments) { "arguments bundle is null" }.run {
        requireNotNull(getParcelable(key)) { "argument for $key is null" }
    }
}