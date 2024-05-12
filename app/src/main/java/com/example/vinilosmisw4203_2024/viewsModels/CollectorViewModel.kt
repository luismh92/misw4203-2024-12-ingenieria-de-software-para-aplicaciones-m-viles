package com.example.vinilosmisw4203_2024.viewsModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosmisw4203_2024.models.Collector
import com.example.vinilosmisw4203_2024.repositories.CollectorRepository
import kotlinx.coroutines.launch

class CollectorViewModel : ViewModel() {
    private val repository = CollectorRepository()
    private val _collectors = MutableLiveData<List<Collector>>()
    val collectors: LiveData<List<Collector>> = _collectors

    fun fetchCollectors() {
        viewModelScope.launch {
            try {
                val listCollectors = repository.getCollectors()
                _collectors.postValue(listCollectors)
            } catch (e: Exception) {
                Log.d("CollectorViewModel", "fetch Collectors exception: ${e.message}")
                _collectors.postValue(emptyList())  // Optionally handle errors by posting an empty list
            }
        }
    }
}
