package com.tf.potterpedie.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.presentation.detail.DetailScreen
import com.tf.potterpedie.presentation.home.HomeScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavGraph(
    onScreenLoaded: () -> Unit
) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        setComposable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navController = navController) { onScreenLoaded() }
        }
        setComposable(
            route = Screen.DetailScreen.route
        ) {
            val characterDetails =
                navController.previousBackStackEntry?.savedStateHandle?.get<HPCharacter>("details")
            if (characterDetails != null) {
                DetailScreen(
                    singleCharacterModel = characterDetails,
                    navHostController = navController
                )
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.setComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit){
    return composable(
        route = route,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Left, animationSpec = tween(400)
            )
        },
        exitTransition = null,
        popEnterTransition = null,
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Right, animationSpec = tween(400)
            )
        },
        content = content
    )
}

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
}