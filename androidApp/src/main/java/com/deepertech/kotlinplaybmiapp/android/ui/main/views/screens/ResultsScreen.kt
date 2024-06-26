package com.deepertech.kotlinplaybmiapp.android.ui.main.views.screens

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.deepertech.kotlinplaybmiapp.android.ui.main.viewmodels.BMIViewModel
import com.deepertech.kotlinplaybmiapp.android.ui.main.views.components.StandardButton

@Composable
fun ResultsScreen(
    navigateToHome: () -> Unit = {}
) {
    val standardPadding = Modifier
        .padding(16.dp, 0.dp, 16.dp, 16.dp)
    Column(
        modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
    ) {
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


            BMIResult()

            Spacer(modifier = Modifier.weight(.3f))

            BMICategory()

            Spacer(modifier = Modifier.weight(.3f))


            BMIDetails()

            Spacer(modifier = Modifier.weight(1f))

            // Buttons
            Box(
                modifier = standardPadding
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Row {
                    StandardButton("Back", navigateToHome)

                    Spacer(modifier = Modifier.padding(8.dp, 0.dp))

                    // TODO:  Implement sharing...
                    StandardButton("Share", navigateToHome)
                }
            }
        }


    }
}

@Composable
private fun BMIDetails(
    viewModel: BMIViewModel = viewModel()
) {
    Column {
        // BMI Details
        Row(
            modifier = Modifier.padding(0.dp, 4.dp)
        ) {
            Text(
                "Healthy BMI range:",
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                viewModel.getHealthyBmiRange(),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Row(
            modifier = Modifier.padding(0.dp, 4.dp)
        ) {
            Text(
                "Healthy weight for the height:",
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                getHealthyWeightForHeight(viewModel),
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        // TODO: Add BMI Prime
//        Row(
//            modifier = Modifier.padding(0.dp, 4.dp)
//        ) {
//            Text(
//                "BMI Prime:",
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                convertToStringWithOneDeciumalPlace(viewModel.getBMIPrime()),
//            )
//        }

        // TODO: Add Ponderal Index
//        Row(
//            modifier = Modifier.padding(0.dp, 4.dp)
//        ) {
//            Text(
//                "Ponderal Index:",
//            )
//
//            Spacer(modifier = Modifier.weight(1f))
//
//            Text(
//                convertToStringWithOneDeciumalPlace(viewModel.getPonderalIndex()) + " kg/m3",
//            )
//        }
    }
}

@Composable
private fun BMICategory(
    viewModel: BMIViewModel = viewModel()
) {
    Text(
        "Your BMI is " + viewModel.getBmiCategory(),
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Composable
private fun BMIResult(
    viewModel: BMIViewModel = viewModel()
) {
    // BMI Result
    Column {
        val value = viewModel.getBmi()
        Text(
            convertToStringWithOneDeciumalPlace(value),
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            "kg/m2",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

private fun convertToStringWithOneDeciumalPlace(value: Double) =
    ((value * 10).toInt() / 10.0).toString()


fun getHealthyWeightForHeight(viewModel: BMIViewModel): String {
    val healthyWeightForHeightUpper = viewModel.getHealthyWeightUpper()
    val healthyWeightForHeightLower = viewModel.getHealthyWeightLower()
    return "${convertToStringWithOneDeciumalPlace(healthyWeightForHeightLower)} - ${
        convertToStringWithOneDeciumalPlace(
            healthyWeightForHeightUpper
        )
    } kg"
}

@Preview
@Composable
fun ResultsScreenPreview() {
    ResultsScreen()
}