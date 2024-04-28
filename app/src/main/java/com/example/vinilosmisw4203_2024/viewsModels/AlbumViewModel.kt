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

    private val respository = AlbumRepository()
    private val _albums = MutableLiveData<List<Album>>()
    val artists: LiveData<List<Album>> = _albums

    fun fetchAlbums() {
        viewModelScope.launch {
            try {
                val listAlbums = respository.getAlbums()
                _albums.value = listAlbums
            }catch (e: Exception){
                Log.d("Repo", "fetch Albums exception ${e.message}")
            }
        }
    }
}