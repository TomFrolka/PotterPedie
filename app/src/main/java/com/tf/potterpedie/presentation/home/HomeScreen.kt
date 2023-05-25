package com.tf.potterpedie.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.tf.potterpedie.domain.core.DataState
import com.tf.potterpedie.presentation.components.ErrorDialog
import com.tf.potterpedie.presentation.components.PotterAppBar
import com.tf.potterpedie.presentation.components.SingleItem
import com.tf.potterpedie.presentation.navigation.Screen
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
    onScreenLoaded: () -> Unit,
) {

    val allCharactersState by homeViewModel.allCharacters.collectAsStateWithLifecycle()

    val lazyGridState = rememberLazyGridState()

    LaunchedEffect(key1 = true){
        onScreenLoaded()
    }

    Scaffold(
        topBar = { PotterAppBar(modifier = Modifier.background(MaterialTheme.colorScheme.background)) },
    ) { paddingValues ->

        when (val state = allCharactersState) {
            is DataState.Loading -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is DataState.Error -> {
                Timber.d(state.toString())
                ErrorDialog {
                    homeViewModel.getAllCharacters()
                }
            }

            is DataState.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = paddingValues,
                    state = lazyGridState,
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    content = {
                        items(state.data) {
                            SingleItem(name = it.name, image = it.image) {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    key = "details",
                                    value = it
                                )
                                navController.navigate(Screen.DetailScreen.route)
                            }
                        }
                    }
                )
            }
        }
    }
}