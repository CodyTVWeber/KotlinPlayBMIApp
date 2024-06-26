package com.deepertech.kotlinplaybmiapp.android.ui.main.views.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StandardButton(text: String, navigateToResults: () -> Unit ) {
    Button(
        onClick = navigateToResults
    ) {
        Spacer(modifier = Modifier.padding(8.dp, 0.dp))
        Text(text)
        Spacer(modifier = Modifier.padding(8.dp, 0.dp))
    }
}