package com.priyanshu.ultimatedrivers.navigation

sealed class Screens(val route: String) {
    data object Splash: Screens("splash_screen")
    data object Home: Screens("home_screen")
}