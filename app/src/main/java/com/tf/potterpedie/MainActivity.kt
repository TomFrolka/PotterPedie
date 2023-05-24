package com.tf.potterpedie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tf.potterpedie.presentation.navigation.MainNavGraph
import com.tf.potterpedie.presentation.theme.PotterpedieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PotterpedieTheme {
                // A surface container using the 'background' color from the theme
                MainNavGraph()
            }
        }
    }
}
