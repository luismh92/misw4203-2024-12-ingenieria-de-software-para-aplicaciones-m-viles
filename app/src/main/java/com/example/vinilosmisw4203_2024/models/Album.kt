package com.example.vinilosmisw4203_2024.models

data class Album(
    val id: Int? = null,
    val name: String,
    val cover: String,
    val releaseDate: String,
    val description: String,
    val genre: String,
    val recordLabel: String
)
