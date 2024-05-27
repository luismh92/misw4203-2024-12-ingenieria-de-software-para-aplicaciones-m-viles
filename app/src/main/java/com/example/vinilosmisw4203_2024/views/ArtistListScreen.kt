package com.example.vinilosmisw4203_2024.views
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.vinilosmisw4203_2024.models.Artist
import com.example.vinilosmisw4203_2024.viewsModels.ArtistViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.vinilosmisw4203_2024.models.Album
import com.example.vinilosmisw4203_2024.models.Collector

@Composable
fun ArtistListScreen(viewModel: ArtistViewModel) {

    var showDetailDialog by remember { mutableStateOf(false) }
    var selectedArtist by remember { mutableStateOf<Artist?>(null) }

    val loading = remember { mutableStateOf(true) }
    val error = remember { mutableStateOf("") }
    val artists by viewModel.artists.observeAsState()

    LaunchedEffect(Unit) {
        try {
            viewModel.fetchArtists()
            loading.value = false
        } catch (e: Exception) {
            error.value = e.message ?: "Unknown error"
            loading.value = false
        }
    }

    if (loading.value) {
        CircularProgressIndicator()
    } else if (error.value.isNotEmpty()) {
        Text("Error: ${error.value}")
    } else {
        artists?.let {
            ArtistList(it){artist->
                selectedArtist = artist
                showDetailDialog = true
            }
        }
    }

    selectedArtist?.let {
        if (showDetailDialog) {
            ArtistDetailScreen(artist = it, onDismissRequest = { showDetailDialog = false })
        }
    }
}

//fun CollectorList(collectors: List<Collector>, onCollectorClick: (Collector) -> Unit) {
@Composable
fun ArtistList(artists: List<Artist>, onCollectorClick: (Artist) -> Unit) {

    val isDark = isSystemInDarkTheme()
    Column {
        Text(text = "12 VINILOS",
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold, fontSize = 30.sp,
            color = if (isDark) Color.White else Color.Black
            )
        LazyColumn {
            items(artists) { artist ->
                ArtistItem(artist, onCollectorClick)
            }
        }
    }
}


@Composable
fun ArtistItem(artist: Artist, onCollectorClick: (Artist) -> Unit) {
    Card(modifier = Modifier.padding(8.dp).clickable { onCollectorClick(artist) },) {
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