package com.example.mpdemo.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mpdemo.ui.theme.white

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = white)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Main Screen")
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
