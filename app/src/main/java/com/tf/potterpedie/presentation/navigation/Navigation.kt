package com.tf.potterpedie.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.tf.potterpedie.presentation.detail.DetailScreen
import com.tf.potterpedie.presentation.home.HomeScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavGraph() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route,
//            enterTransition =, TODO: transitions anims
//            exitTransition = ,
        ) {
            HomeScreen(navController = navController)
        }
        composable(Screen.DetailScreen.route) {
            DetailScreen()
        }
    }

}

sealed class Screen(val route: String, vararg val args: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen", CHARACTER_DETAIL_ID)
}

private const val CHARACTER_DETAIL_ID = "detail_id"