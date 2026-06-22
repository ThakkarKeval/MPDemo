package com.example.mpdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform