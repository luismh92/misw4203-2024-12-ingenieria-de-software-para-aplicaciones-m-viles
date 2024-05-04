package com.example.vinilosmisw4203_2024.repositories

import com.example.vinilosmisw4203_2024.models.Collector
import com.example.vinilosmisw4203_2024.services.CollectorRetrofitInstance

class CollectorRepository {
    private val collectorService = CollectorRetrofitInstance.api
    suspend fun getCollectors(): List<Collector> {
        return collectorService.getCollectors()
    }
}