package com.example.vinilosmisw4203_2024.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.vinilosmisw4203_2024.models.Collector

@Composable
fun CollectorDetailDialog(collector: Collector, onDismissRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = { Text(text = collector.name) },
        text = {
            Column {
                Text("Email: ${collector.email}")
                Text("Telephone: ${collector.telephone}")
                // Aquí podrías agregar más detalles como los álbumes y artistas favoritos
            }
        },
        confirmButton = {
            Button(onClick = { onDismissRequest() }) {
                Text("Cerrar")
            }
        }
    )
}
