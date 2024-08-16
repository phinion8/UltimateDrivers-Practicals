package com.priyanshu.ultimatedrivers.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.priyanshu.ultimatedrivers.R
import com.priyanshu.ultimatedrivers.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun Splashscreen(
    navController: NavController
) {

    LaunchedEffect(key1 = Unit) {
        delay(1500)
        navController.navigate(Screens.Home.route)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "App Logo"
            )
        }

    }

}