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
    private val respository = CollectorRepository()
    private val _collectors = MutableLiveData<List<Collector>>()
    val collectors: LiveData<List<Collector>> = _collectors

    fun fetchCollector() {
        viewModelScope.launch {
            try {
                val listCollector = respository.getCollectors()
                _collectors.value = listCollector
            }catch (e: Exception){
                Log.d("Repo", "fetch Collector exception ${e.message}")
            }
        }
    }
}