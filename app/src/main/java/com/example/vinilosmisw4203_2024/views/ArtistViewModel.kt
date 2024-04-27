package com.example.vinilosmisw4203_2024.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.vinilosmisw4203_2024.models.Artist
import com.example.vinilosmisw4203_2024.services.ArtistService
import com.example.vinilosmisw4203_2024.services.ArtistRetrofitInstance
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

@Composable
fun ArtistList(items: List<Artist>) {
    LazyColumn {
        items(items) { artist ->
            ArtistItem(artist)
        }
    }
}

@Composable
fun ArtistItem(artist: Artist) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(
                    data = artist.image,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = "Album Cover",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop // Ajusta cómo se ajusta la imagen dentro de su contenedor
            )
            Text(artist.name, style = MaterialTheme.typography.h6)
        }
    }
}