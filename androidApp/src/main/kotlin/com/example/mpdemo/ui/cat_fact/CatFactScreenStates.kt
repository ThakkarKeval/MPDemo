package com.example.mpdemo.ui.cat_fact

import com.example.mpdemo.data.CatFact

data class CatFactScreenStates(
    val catFact: CatFact? = null,
    val isLoading: Boolean = false,
)
