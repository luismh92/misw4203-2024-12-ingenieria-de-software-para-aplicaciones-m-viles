package com.example.vinilosmisw4203_2024.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vinilosmisw4203_2024.R
import com.example.vinilosmisw4203_2024.viewsModels.AlbumViewModel
import com.example.vinilosmisw4203_2024.viewsModels.ArtistViewModel
import com.example.vinilosmisw4203_2024.viewsModels.CollectorViewModel
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CollectorScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { CoBottomNavigationBar(navController) }
    ) {
        CoNavigationGraph(navController)
    }
}


@Composable
fun CoBottomNavigationBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = Color.Gray,
        contentColor = Color.Black
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.album_icon),
                    contentDescription = "Álbum",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text("Álbum", fontSize = 10.sp) },
            selected = false,
            onClick = { navController.navigate("ALbums") },
            alwaysShowLabel = true
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.music_solid),
                    contentDescription = "Song",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text("Song", fontSize = 10.sp) },
            selected = false,
            onClick = { navController.navigate("Songs") },
            alwaysShowLabel = true
        )
    }
}

@Composable
fun CoNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "Albums") {
        composable("Songs") {
            SongCreateScreen()
        }
        composable("ALbums") {
            AlbumCreateScreen()
        }
    }
}