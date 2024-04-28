package com.example.vinilosmisw4203_2024.views

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.vinilosmisw4203_2024.models.Artist
import com.example.vinilosmisw4203_2024.services.ArtistRetrofitInstance
import com.example.vinilosmisw4203_2024.services.ArtistService
import com.example.vinilosmisw4203_2024.viewsModels.ArtistList
import kotlinx.coroutines.launch

@Composable
fun ArtistListScreen(apiService: ArtistService = ArtistRetrofitInstance.api) {
    val artists = remember { mutableStateOf<List<Artist>?>(null) }
    val loading = remember { mutableStateOf(true) }
    val error = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                artists.value = apiService.getArtists()
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
        artists.value?.let { ArtistList(it) }
    }
}