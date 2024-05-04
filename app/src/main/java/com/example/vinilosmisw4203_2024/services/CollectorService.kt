package com.example.vinilosmisw4203_2024.services

import com.example.vinilosmisw4203_2024.models.Collector
import retrofit2.http.GET

interface CollectorService {
    @GET("collectors")
    suspend fun getCollectors(): List<Collector>
}