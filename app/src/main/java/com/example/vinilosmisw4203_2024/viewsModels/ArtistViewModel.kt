package com.example.vinilosmisw4203_2024.viewsModels
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.vinilosmisw4203_2024.models.Artist
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.vinilosmisw4203_2024.repositories.ArtistRepository
import kotlinx.coroutines.launch

class ArtistViewModel : ViewModel() {

    private val respository = ArtistRepository()
    private val _artists = MutableLiveData<List<Artist>>()
    val artists: LiveData<List<Artist>> = _artists

    fun fetchArtist() {
        viewModelScope.launch {
            try {
                val listArtist = respository.getArtists()
                _artists.value = listArtist
            }catch (e: Exception){
                Log.d("Repo", "fetch Artist exception ${e.message}")
            }
        }
    }
}



