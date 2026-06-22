package com.example.mpdemo.ui.cat_fact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mpdemo.R
import com.example.mpdemo.data.CatFact
import com.example.mpdemo.ui.theme.black
import com.example.mpdemo.ui.theme.white
import org.koin.androidx.compose.koinViewModel

@Composable
fun CatFactScreen() {
    val vm: CatFactScreenVM = koinViewModel()
    val state by vm.state.collectAsState()

    CatFactScreenContent(
        state = state,
        onIntent = vm::handleIntent
    )
}

@Composable
fun CatFactScreenContent(
    state: CatFactScreenStates,
    onIntent: (CatFactScreenIntents) -> Unit
) {
    Box(
        modifier = Modifier
            .background(color = white)
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 20.dp),
                    text = stringResource(R.string.cat_fact),
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W600,
                    color = black
                )
                if (state.isLoading) {
                    CircularProgressIndicator()
                } else {
                    Text(
                        text = state.catFact?.fact ?: "",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = black
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { onIntent(CatFactScreenIntents.ClkRefresh) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.get_another_fact))
            }
        }
    }
}

@Preview
@Composable
private fun CatFactScreenPreview() {
    CatFactScreenContent(
        state = CatFactScreenStates(
            catFact = CatFact(fact = "Cats sleep 70% of their lives.", length = 30)
        ),
        onIntent = {}
    )
}
