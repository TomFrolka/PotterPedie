package com.tf.potterpedie.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tf.potterpedie.R
import com.tf.potterpedie.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
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
                navController.navigate(Screen.DetailScreen.route) {}
            }
    )

    val lazyGridState = rememberLazyGridState()
//    val characters = homeViewModel.characters.collectAsState(initial = NetworkResult.Idle)


//    Scaffold(topBar = { HomeTopBar() }) { paddingValues ->
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(3),
//            contentPadding = paddingValues,
//            state = lazyGridState,
//            horizontalArrangement = Arrangement.spacedBy(20.dp),
//            verticalArrangement = Arrangement.spacedBy(20.dp),
//            content = {
//                items(characters) {
//                    Column(
//                        modifier = Modifier
////                            .clickable { onClick() }
//                            .padding(10.dp)
//                            .fillMaxWidth()
//                    ) {
//                        AsyncImage(
//                            model = it.image,
//                            contentDescription = "image",
//                            alignment = Alignment.Center,
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier
//                                .padding(5.dp)
//                                .fillMaxWidth()
//                                .height(300.dp)
//                                .aspectRatio(1f)
//                                .clip(CircleShape)           ,
//                            placeholder = painterResource(id = R.drawable.placeholder)
//                        )
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Text(
//                            text = it.name,
//                            fontSize = 25.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    }
//                }
//            }
//        )
//    }
}

@Composable
fun HomeTopBar() {

}