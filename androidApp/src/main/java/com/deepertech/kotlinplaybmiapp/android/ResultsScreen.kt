package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ResultsScreen(navigateToHome: () -> Unit = {}) {
    Button(onClick = navigateToHome) {
        Text("Go to Home Screen")
    }
}