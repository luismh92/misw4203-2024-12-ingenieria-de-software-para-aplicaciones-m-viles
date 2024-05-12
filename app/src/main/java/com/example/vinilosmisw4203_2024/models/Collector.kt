package com.example.vinilosmisw4203_2024.models

data class Collector(
    val id: Int,
    val name: String,
    val telephone: String,
    val email: String,
    val comments: List<Comment>,
    val favoritePerformers: List<Performer>,
    val collectorAlbums: List<CollectorAlbum>,
    val image: String
)

data class Comment(
    val id: Int,
    val description: String,
    val rating: Int
)

data class Performer(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val birthDate: String
)

data class CollectorAlbum(
    val id: Int,
    val price: Int,
    val status: String
)
