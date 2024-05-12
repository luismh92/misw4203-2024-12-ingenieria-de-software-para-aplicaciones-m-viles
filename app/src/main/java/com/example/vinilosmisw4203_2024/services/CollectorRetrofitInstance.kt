package com.example.vinilosmisw4203_2024.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CollectorRetrofitInstance {
    val api: CollectorService by lazy {
        Retrofit.Builder()
            .baseUrl("http://54.227.206.253:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CollectorService::class.java)
    }
}