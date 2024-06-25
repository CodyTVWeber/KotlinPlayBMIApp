package com.deepertech.kotlinplaybmiapp.android.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(navigateToResults: () -> Unit = {}) {
    val standardPadding = Modifier
        .padding(16.dp, 0.dp, 16.dp, 16.dp)

    Column(
        modifier = Modifier
            .padding(0.dp, 16.dp, 0.dp, 0.dp)
            .fillMaxSize()
    ) {
        val standardWeightedPadding = standardPadding
            .weight(1f)

        Column(
            modifier = standardPadding
        ) {
            Text(
                "BMI Calculator", style = MaterialTheme.typography.titleLarge
            )
            Text(
                "Body Mass Index (BMI) is a person's weight in kilograms divided by the square of height in meters.",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Row(
            modifier = standardWeightedPadding
        ) {
            Card(modifier = Modifier.weight(1f)) {
                GenderPicker()
            }
            Spacer(modifier = Modifier.padding(8.dp, 0.dp))
            Card(modifier = Modifier.weight(1f)) {
                AgePicker()
            }
        }
        Row(
            modifier = standardWeightedPadding
        ) {
            Card {
                HeightPicker()
            }
        }
        Row(
            modifier = standardWeightedPadding
        ) {
            Card {
                WeightPicker()
            }
        }
        Box(
            modifier = standardPadding
                .fillMaxWidth(),
            contentAlignment = androidx.compose.ui.Alignment.Center,
        ) {
            StandardButton("Calculate",navigateToResults)
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}