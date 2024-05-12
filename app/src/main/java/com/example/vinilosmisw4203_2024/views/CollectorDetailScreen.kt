package com.example.vinilosmisw4203_2024.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.vinilosmisw4203_2024.models.Collector
import coil.compose.rememberImagePainter

@Composable
fun CollectorDetailScreen(collector: Collector) {
    Dialog(onDismissRequest = { /* TODO: Handle dismiss */ }) {
        Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = collector.name, style = MaterialTheme.typography.h6)
                Text(text = "Teléfono: ${collector.telephone}", style = MaterialTheme.typography.body2)
                Text(text = "Correo: ${collector.email}", style = MaterialTheme.typography.body2)
                // Incluye más detalles según lo necesites
            }
        }
    }
}