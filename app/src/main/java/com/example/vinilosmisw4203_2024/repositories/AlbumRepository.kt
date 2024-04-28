package com.example.vinilosmisw4203_2024.repositories
import com.example.vinilosmisw4203_2024.models.Album
import com.example.vinilosmisw4203_2024.services.RetrofitInstance


class AlbumRepository {
    private val abumService = RetrofitInstance.api
    suspend fun getAlbums(): List<Album> {
        return abumService.getAlbums()
    }
}