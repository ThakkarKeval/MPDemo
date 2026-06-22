package com.example.mpdemo.ui.cat_fact

sealed class CatFactScreenIntents {
    data object LoadFact : CatFactScreenIntents()
    data object ClkRefresh : CatFactScreenIntents()
}
