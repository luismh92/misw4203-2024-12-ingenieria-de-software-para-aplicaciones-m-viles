package com.example.vinilosmisw4203_2024.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vinilosmisw4203_2024.models.Collector
import com.example.vinilosmisw4203_2024.viewsModels.CollectorViewModel

@Composable
fun CollectorListScreen(viewModel: CollectorViewModel) {
    var selectedCollector by remember { mutableStateOf<Collector?>(null) }
    val collectors by viewModel.collectors.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchCollectors()
    }

    LazyColumn {
        items(collectors) { collector ->
            CollectorItem(collector) {
                selectedCollector = it
            }
        }
    }

    selectedCollector?.let {
        // Aquí se abriría la modal con los detalles del coleccionista
        CollectorDetailDialog(collector = it) {
            selectedCollector = null // Para cerrar la modal
        }
    }
}

@Composable
fun CollectorItem(collector: Collector, onClick: (Collector) -> Unit) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clickable { onClick(collector) },
        elevation = 2.dp) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = collector.name, style = MaterialTheme.typography.h6)
            Text(text = "Tel: ${collector.telephone}", style = MaterialTheme.typography.body2)
            Text(text = "Email: ${collector.email}", style = MaterialTheme.typography.body2)
        }
    }
}
