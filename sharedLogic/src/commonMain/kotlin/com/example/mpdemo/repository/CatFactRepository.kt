package com.example.mpdemo.repository

import com.example.mpdemo.data.CatFact
import com.example.mpdemo.network.HttpClientFactory
import io.ktor.client.call.body
import io.ktor.client.request.get

class CatFactRepository {
    private val client = HttpClientFactory.create()

    suspend fun getCatFact(): CatFact {
        return client.get("https://catfact.ninja/fact").body()
    }
}
