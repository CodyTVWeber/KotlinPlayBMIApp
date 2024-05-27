package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.value.getAndUpdate

@Composable
fun HomeScreen(
    homeComponent: HomeComponent
) {
    // TODO:  Fix this...
    val text = homeComponent.text.value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = { homeComponent.onEvent(HomeEvent.UpdateText(it)) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { homeComponent.onEvent(HomeEvent.ClickResultsButton) }
        ) {
            Text("Results")
        }
    }
}