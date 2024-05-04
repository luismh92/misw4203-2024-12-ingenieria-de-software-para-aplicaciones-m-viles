package com.example.vinilosmisw4203_2024.views

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vinilosmisw4203_2024.models.Collector
import com.example.vinilosmisw4203_2024.viewsModels.CollectorViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun CollectorListScreen(viewModel: CollectorViewModel) {
    val loading = remember { mutableStateOf(true) }
    val error = remember { mutableStateOf("") }
    val collectors by viewModel.collectors.observeAsState()

    LaunchedEffect(Unit) {
        try {
            viewModel.fetchCollector()
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
        collectors?.let { CollectorList(it) }
    }
}

@Composable
fun CollectorList(items: List<Collector>) {
    Column {
        Text(text = "12 VINILOS",
            modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold, fontSize = 30.sp)
        LazyColumn {
            items(items) { collector ->
                CollectorItem(collector)
            }
        }
    }
}

@Composable
fun CollectorItem(collector: Collector) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(collector.name, style = MaterialTheme.typography.h6)
        }
    }
}