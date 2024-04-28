package com.example.vinilosmisw4203_2024.views

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.vinilosmisw4203_2024.models.Album
import com.example.vinilosmisw4203_2024.services.AlbumService
import com.example.vinilosmisw4203_2024.services.RetrofitInstance
import com.example.vinilosmisw4203_2024.viewsModels.AlbumList
import kotlinx.coroutines.launch

@Composable
fun AlbumListScreen(apiService: AlbumService = RetrofitInstance.api) {
    val albums = remember { mutableStateOf<List<Album>?>(null) }
    val loading = remember { mutableStateOf(true) }
    val error = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                albums.value = apiService.getAlbums()
                loading.value = false
            } catch (e: Exception) {
                error.value = e.localizedMessage ?: "An unknown error occurred"
                loading.value = false
            }
        }
    }

    if (loading.value) {
        CircularProgressIndicator()
    } else if (error.value.isNotEmpty()) {
        Text("Error: ${error.value}")
    } else {
        albums.value?.let { AlbumList(it) }
    }
}
