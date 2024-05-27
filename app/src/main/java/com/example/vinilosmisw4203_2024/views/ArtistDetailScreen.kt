package com.example.vinilosmisw4203_2024.views

import androidx.compose.foundation.Image
<<<<<<< HEAD
import androidx.compose.foundation.isSystemInDarkTheme
=======
>>>>>>> a4c5ad9917c9fdebd07d99409e1934b324a4c584
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
<<<<<<< HEAD
import androidx.compose.ui.graphics.Color
=======
>>>>>>> a4c5ad9917c9fdebd07d99409e1934b324a4c584
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.vinilosmisw4203_2024.models.Artist
import androidx.compose.ui.window.Dialog
import com.example.vinilosmisw4203_2024.models.Collector

@Composable
fun ArtistDetailScreen(artist: Artist, onDismissRequest: () -> Unit) {
    val isDark = isSystemInDarkTheme()
    val color = if (isDark) Color.White else Color.Black
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = {
            Text(text = artist.name, color=color)
        },
        text = {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = rememberImagePainter(artist.image),
                    contentDescription = "Album Cover",
                    modifier = Modifier.height(200.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = artist.name, style = MaterialTheme.typography.h6, color=color)
                Text(text = "BirthDate: ${artist.birthDate}", style = MaterialTheme.typography.body2, color=color)
                Text(text = artist.description, style = MaterialTheme.typography.body1, color=color)
            }
        },
        confirmButton = {
            Button(onClick = { onDismissRequest() }) {
                Text("Cerrar", color=color)
            }
        }
    )
}