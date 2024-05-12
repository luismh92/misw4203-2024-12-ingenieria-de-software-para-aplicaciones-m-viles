package com.example.vinilosmisw4203_2024.viewsModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.vinilosmisw4203_2024.models.Collector
import com.example.vinilosmisw4203_2024.repositories.CollectorRepository

class CollectorViewModel(private val repository: CollectorRepository) : ViewModel() {
    private val _collectors = MutableStateFlow<List<Collector>>(emptyList())
    val collectors: StateFlow<List<Collector>> = _collectors

    fun fetchCollectors() {
        viewModelScope.launch {
            try {
                _collectors.value = repository.getCollectors()
            } catch (e: Exception) {
                // Manejo de errores, podría loggear o manejar el estado de error de forma más compleja
                _collectors.value = emptyList()
            }
        }
    }
}
