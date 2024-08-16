package com.priyanshu.ultimatedrivers.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.priyanshu.ultimatedrivers.ui.screens.home.HomeScreen
import com.priyanshu.ultimatedrivers.ui.screens.splash.Splashscreen

@Composable
fun SetUpNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.Splash.route){

        composable(route = Screens.Splash.route){
            Splashscreen(navController = navController)
        }

        composable(route = Screens.Home.route){
            HomeScreen()
        }

    }

}