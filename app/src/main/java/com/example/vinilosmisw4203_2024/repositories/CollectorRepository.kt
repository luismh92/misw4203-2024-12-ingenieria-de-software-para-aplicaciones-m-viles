package com.example.vinilosmisw4203_2024.repositories
import com.example.vinilosmisw4203_2024.models.Collector
import com.example.vinilosmisw4203_2024.services.CollectorRetrofitInstance
import android.util.LruCache

class CollectorRepository {
    private val collectorService = CollectorRetrofitInstance.api
    private val collectorCache: LruCache<String, List<Collector>> = LruCache(50)

    suspend fun getCollectors(): List<Collector> {
        return collectorCache.get("collectors") ?: fetchAndCacheCollectors()
    }

    private suspend fun fetchAndCacheCollectors(): List<Collector> {
        val collectors = collectorService.getCollectors()
        collectorCache.put("collectors", collectors)
        return collectors
    }
}
