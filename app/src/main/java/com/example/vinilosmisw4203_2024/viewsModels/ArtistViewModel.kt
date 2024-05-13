package com.example.vinilosmisw4203_2024.viewsModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosmisw4203_2024.models.Artist
import com.example.vinilosmisw4203_2024.repositories.ArtistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistViewModel : ViewModel() {
    private val repository = ArtistRepository()
    private val _artists = MutableLiveData<List<Artist>>()
    val artists: LiveData<List<Artist>> = _artists

    fun fetchArtists() {
        _artists.value = listOf() // Pre-clear the current artist list
        viewModelScope.launch(Dispatchers.IO) { // IMPLEMANTACION DE ANRs UTILIZANDO VIEWMODELSCOPE.LAUNCH(DISPATCHERS.IO)
            try {
                val listArtists = repository.getArtists()
                _artists.postValue(listArtists)
            } catch (e: Exception) {
                Log.d("ArtistViewModel", "fetch Artists exception: ${e.message}")
                _artists.postValue(emptyList()) // Manejo de errores postando una lista vacía
            }
        }
    }
}
