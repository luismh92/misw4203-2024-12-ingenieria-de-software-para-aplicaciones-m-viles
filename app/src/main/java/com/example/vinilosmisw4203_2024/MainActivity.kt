package com.example.vinilosmisw4203_2024


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vinilosmisw4203_2024.ui.theme.VinilosMisw42032024Theme
import com.example.vinilosmisw4203_2024.views.CollectionistScreen
import com.example.vinilosmisw4203_2024.views.UserScreen
import com.example.vinilosmisw4203_2024.views.LoginScreen


class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        VinilosMisw42032024Theme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") { LoginScreen(navController) }
                    composable("User") { UserScreen() }
                    composable("Collectionist") { CollectionistScreen() }
                }
            }
        }
    }
}

}