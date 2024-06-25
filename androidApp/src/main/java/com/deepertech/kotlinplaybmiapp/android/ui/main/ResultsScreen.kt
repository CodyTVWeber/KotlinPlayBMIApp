package com.deepertech.kotlinplaybmiapp.android.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ResultsScreen(navigateToHome: () -> Unit = {}) {
    val standardPadding = Modifier
        .padding(16.dp, 0.dp, 16.dp, 16.dp)
    Column (
        modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
    ){
        Text(
            "Your result",
            style = MaterialTheme.typography.titleLarge,
            modifier = standardPadding
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            // TODO: Add Speedometer for categories.
            // If underweight, show yellow
            // If normal, show green
            // If overweight, show orange
            // If obese, show dark orange
            // If severely obese, show red

            
            // BMI Result
            // TODO: Add BMI calculation here
            Column {
                Text(
                    "20.1", // TODO:  replace with ViewModel category value
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    "kg/m2",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Spacer(modifier = Modifier.weight(.3f))

            // BMI Category
            Text(
                "Your BMI is TODO", // TODO:  replace with ViewModel category value
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.weight(.3f))

            // BMI Details
            // TODO:  Add ViewModel values
            Column {
                Row (
                    modifier = Modifier.padding(0.dp, 4.dp)
                ) {
                    Text(
                        "Healthy BMI range:",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        "18.5 - 24.9 kg/m2",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                Row (
                    modifier = Modifier.padding(0.dp, 4.dp)
                ){
                    Text(
                        "Healthy weight for the height:",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        "59.9 kg/m2 - 81.1 kg/m2",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                Row (
                    modifier = Modifier.padding(0.dp, 4.dp)
                ) {
                    Text(
                        "BMI Prime:",
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        "0.74",
                    )
                }
                Row (
                    modifier = Modifier.padding(0.dp, 4.dp)
                ) {
                    Text(
                        "Ponderal Index:",
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        "13.6 kg/m3",
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))

            // Buttons
            Box(
                modifier = standardPadding
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Row{
                    StandardButton("Back", navigateToHome)
                    Spacer(modifier = Modifier.padding(8.dp, 0.dp))
                    StandardButton("Share", navigateToHome)
                }
            }
        }


    }
}

@Preview
@Composable
fun ResultsScreenPreview() {
    ResultsScreen()
}