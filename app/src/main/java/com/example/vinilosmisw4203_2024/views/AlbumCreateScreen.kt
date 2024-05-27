package com.example.vinilosmisw4203_2024.views

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vinilosmisw4203_2024.models.Album
import com.example.vinilosmisw4203_2024.viewsModels.AlbumViewModel

@Composable
fun AlbumCreateScreen() {
    val viewModel: AlbumViewModel = viewModel()
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var cover by remember { mutableStateOf("") }
    var releaseDate by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    val recordLabel = "Sony Music"

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Album Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = cover,
            onValueChange = { cover = it },
            label = { Text("Cover URL") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = releaseDate,
            onValueChange = { releaseDate = it },
            label = { Text("Release Date") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = genre,
            onValueChange = { genre = it },
            label = { Text("Genre") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (name.isBlank() || cover.isBlank() || releaseDate.isBlank() || description.isBlank() || genre.isBlank()) {
                    Toast.makeText(context, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.createAlbum(
                        Album(
                            name = name,
                            cover = cover,
                            releaseDate = releaseDate,
                            description = description,
                            genre = genre,
                            recordLabel = recordLabel
                        ),
                        onSuccess = {
                            Toast.makeText(context, "Album creado", Toast.LENGTH_SHORT).show()
                            name = ""
                            cover = ""
                            releaseDate = ""
                            description = ""
                            genre = ""
                        },
                        onError = { errorMsg ->
                            Toast.makeText(context, "Failed to create album: $errorMsg", Toast.LENGTH_LONG).show()
                        }
                    )
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Create Album")
        }
    }
}