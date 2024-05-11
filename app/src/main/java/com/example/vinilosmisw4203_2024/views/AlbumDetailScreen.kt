package com.example.vinilosmisw4203_2024.views

import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.vinilosmisw4203_2024.models.Album
import coil.compose.rememberImagePainter

@Composable
fun AlbumDetailScreen(album: Album) {
    Dialog(onDismissRequest = { /* TODO: Handle dismiss */ }) {
        Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = rememberImagePainter(album.cover),
                    contentDescription = "Album Cover",
                    modifier = Modifier.height(200.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = album.name, style = MaterialTheme.typography.h6)
                Text(text = "Genero: ${album.genre}", style = MaterialTheme.typography.body2)
                Text(text = "Lanzamiento: ${album.releaseDate}", style = MaterialTheme.typography.body2)
                Text(text = album.description, style = MaterialTheme.typography.body1)
            }
        }
    }
}
