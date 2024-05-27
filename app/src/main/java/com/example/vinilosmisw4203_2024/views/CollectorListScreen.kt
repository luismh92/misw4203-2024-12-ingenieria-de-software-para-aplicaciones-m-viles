package com.example.vinilosmisw4203_2024.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.vinilosmisw4203_2024.models.Collector
import com.example.vinilosmisw4203_2024.viewsModels.CollectorViewModel

@Composable
fun CollectorListScreen(viewModel: CollectorViewModel) {
    var showDetailDialog by remember { mutableStateOf(false) }
    var selectedCollector by remember { mutableStateOf<Collector?>(null) }

    val loading = remember { mutableStateOf(true) }
    val error = remember { mutableStateOf("") }
    val collectors by viewModel.collectors.observeAsState()

    LaunchedEffect(Unit) {
        try {
            viewModel.fetchCollectors()
            loading.value = false
        } catch (e: Exception) {
            error.value = e.message ?: "Error desconocido"
            loading.value = false
        }
    }

    if (loading.value) {
        CircularProgressIndicator()
    } else if (error.value.isNotEmpty()) {
        Text("Error: ${error.value}")
    } else {
        collectors?.let {
            CollectorList(it) { collector ->
                selectedCollector = collector
                showDetailDialog = true
            }
        }
    }

    selectedCollector?.let {
        if (showDetailDialog) {
            CollectorDetailDialog(collector = it, onDismissRequest = { showDetailDialog = false })
        }
    }
}

@Composable
fun CollectorList(collectors: List<Collector>, onCollectorClick: (Collector) -> Unit) {
    val isDark = isSystemInDarkTheme()
    Column {
        Text(
            text = "Coleccionistas",
            modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally),
            fontSize = 30.sp,
            color = if (isDark) Color.White else Color.Black
        )
        LazyColumn {
            items(collectors) { collector ->
                CollectorItem(collector, onCollectorClick)
            }
        }
    }
}

@Composable
fun CollectorItem(collector: Collector, onCollectorClick: (Collector) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onCollectorClick(collector) },
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(
                    data = collector.image,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = "Foto del Coleccionista",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(collector.name, fontSize = 18.sp)
                Text("Tel: ${collector.telephone}", fontSize = 14.sp)
                Text("Email: ${collector.email}", fontSize = 14.sp)
            }
        }
    }
}


@Composable
fun CollectorDetailDialog(collector: Collector, onDismissRequest: () -> Unit) {
    val isDark = isSystemInDarkTheme()
    val color = if (isDark) Color.White else Color.Black
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = {
            Text(text = collector.name, color= color)
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberImagePainter(collector.image),
                    contentDescription = "Foto del Coleccionista",
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Text("Teléfono: ${collector.telephone}", color= color)
                Text("Correo: ${collector.email}", color=color)
                // Agrega más detalles según sea necesario
            }
        },
        confirmButton = {
            Button(onClick = { onDismissRequest() }) {
                Text("Cerrar", color=color)
            }
        }
    )
}