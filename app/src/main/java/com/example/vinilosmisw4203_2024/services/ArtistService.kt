package com.example.vinilosmisw4203_2024.services
import com.example.vinilosmisw4203_2024.models.Artist
import retrofit2.http.GET

interface ArtistService {
    @GET("musicians")
    suspend fun getArtists(): List<Artist>
}