package com.tf.potterpedie.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tf.potterpedie.presentation.navigation.Screen

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    Text(
        text = "Home screen",
        fontSize = 40.sp,
        modifier = Modifier
            .clickable {
            navController.navigate(Screen.DetailScreen.route){}
        }
    )

}