package com.example.vinilosmisw4203_2024.repositories
import com.example.vinilosmisw4203_2024.models.Artist
import com.example.vinilosmisw4203_2024.services.ArtistRetrofitInstance


class ArtistRepository {
    private val artistService = ArtistRetrofitInstance.api
    suspend fun getArtists(): List<Artist> {
        return artistService.getArtists()
    }
}