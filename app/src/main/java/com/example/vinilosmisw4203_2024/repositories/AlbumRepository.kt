package com.example.vinilosmisw4203_2024.repositories
import com.example.vinilosmisw4203_2024.models.Album
import com.example.vinilosmisw4203_2024.services.RetrofitInstance
import android.util.LruCache



class AlbumRepository {
    private val albumService = RetrofitInstance.api
    private val albumCache: LruCache<String, List<Album>> = LruCache(50)

    suspend fun getAlbums(): List<Album> {
        return albumCache.get("albums") ?: fetchAndCacheAlbums()
    }

    private suspend fun fetchAndCacheAlbums(): List<Album> {
        val albums = albumService.getAlbums()
        albumCache.put("albums", albums)
        return albums
    }

    suspend fun createAlbum(album: Album): Album {
        return albumService.createAlbum(album)
    }
}
