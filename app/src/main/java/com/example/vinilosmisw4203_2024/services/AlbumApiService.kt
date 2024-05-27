package com.example.vinilosmisw4203_2024.services

import com.example.vinilosmisw4203_2024.models.Album
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AlbumService {
    @GET("albums")
    suspend fun getAlbums(): List<Album>

    @Headers("Content-Type: application/json")
    @POST("albums")
    suspend fun createAlbum(@Body album: Album): Album
}
