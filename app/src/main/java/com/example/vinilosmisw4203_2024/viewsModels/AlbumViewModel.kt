package com.example.vinilosmisw4203_2024.viewsModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosmisw4203_2024.models.Album
import com.example.vinilosmisw4203_2024.repositories.AlbumRepository
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel() {

    private val repository = AlbumRepository()  // Correct the spelling mistake here
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums  // Changed from 'artists' to 'albums'

    fun fetchAlbums() {
        viewModelScope.launch {
            try {
                val listAlbums = repository.getAlbums()  // Correct the method call to match the correct spelling of the repository instance
                _albums.postValue(listAlbums)
            } catch (e: Exception) {
                Log.d("AlbumViewModel", "fetch Albums exception: ${e.message}")
                _albums.postValue(emptyList())  // Optionally handle errors by posting an empty list
            }
        }
    }
}
