package com.priyanshu.ultimatedrivers.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = white,
    secondary = darkBlue,
    tertiary = blue,
    background = darkBlue,
    onPrimary = white,
    onSecondary = white,
    onTertiary = white,
    onBackground = white,
    onSurface = Color(0xFF1C1B1F),
    secondaryContainer = darkBlue,
    surfaceContainer = darkBlue,

    )

private val LightColorScheme = lightColorScheme(
    primary = darkBlue,
    secondary = white,
    tertiary = blue,
    background = white,
    surface = Color(0xFFFFFBFE),
    onPrimary = darkBlue,
    onSecondary = darkBlue,
    onTertiary = darkBlue,
    onBackground = darkBlue,
    onSurface = lightGray
)

@Composable
fun UltimateDriversTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.secondary.toArgb()
            window.navigationBarColor = colorScheme.secondary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }

        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}