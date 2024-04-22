package com.example.vinilosmisw4203_2024.services

import com.example.vinilosmisw4203_2024.models.Album
import retrofit2.http.GET
interface AlbumService {
    @GET("albums")
    suspend fun getAlbums(): List<Album>
}
