package com.example.vinilosmisw4203_2024.viewsModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosmisw4203_2024.models.Album
import com.example.vinilosmisw4203_2024.repositories.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel() {
    private val repository = AlbumRepository()
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchAlbums() {
        _isLoading.value = true// OPERACIONES DE RED NO VAN AL HILO PRINCIPAL
        viewModelScope.launch(Dispatchers.IO) {// IMPLEMANTACION DE ANRs UTILIZANDO VIEWMODELSCOPE.LAUNCH(DISPATCHERS.IO)
            try {
                val listAlbums = repository.getAlbums()
                _albums.postValue(listAlbums)
                _isLoading.postValue(false)
            } catch (e: Exception) {
                Log.d("AlbumViewModel", "fetch Albums exception: ${e.message}")
                _error.postValue(e.message ?: "An unknown error occurred")
                _isLoading.postValue(false)
            }
        }
    }
}