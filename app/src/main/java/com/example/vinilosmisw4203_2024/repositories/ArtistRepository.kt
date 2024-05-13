package com.example.vinilosmisw4203_2024.repositories
import com.example.vinilosmisw4203_2024.models.Artist
import com.example.vinilosmisw4203_2024.services.ArtistRetrofitInstance
import android.util.LruCache

class ArtistRepository {
    private val artistService = ArtistRetrofitInstance.api
    private val artistCache: LruCache<String, List<Artist>> = LruCache(50) 

    suspend fun getArtists(): List<Artist> {
        return artistCache.get("artists") ?: fetchAndCacheArtists()
    }

    private suspend fun fetchAndCacheArtists(): List<Artist> {
        val artists = artistService.getArtists()
        artistCache.put("artists", artists)
        return artists
    }
}
