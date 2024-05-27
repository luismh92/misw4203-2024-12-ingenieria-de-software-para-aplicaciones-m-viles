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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumCreateScreen() {
    val viewModel: AlbumViewModel = viewModel()
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var cover by remember { mutableStateOf("") }
    var releaseDate by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var recordLabel by remember { mutableStateOf("") }

    Button(
        onClick = {
            viewModel.createAlbum(
                Album(
                    name = name,
                    cover = cover,
                    releaseDate = releaseDate,
                    description = description,
                    genre = genre,
                    recordLabel = recordLabel
                )
            ) {
                Toast.makeText(context, "Album creado", Toast.LENGTH_SHORT).show()
            }
        },
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text("Create Album")
    }
}