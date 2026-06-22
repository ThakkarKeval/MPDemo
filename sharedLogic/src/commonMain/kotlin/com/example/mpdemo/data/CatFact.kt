package com.example.mpdemo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatFact(
    @SerialName("fact")
    val fact: String = "",

    @SerialName("length")
    val length: Int = 0
)
