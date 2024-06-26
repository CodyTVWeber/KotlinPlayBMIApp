package com.deepertech.kotlinplaybmiapp.android.ui.main.views.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.deepertech.kotlinplaybmiapp.android.ui.main.viewmodels.BMIViewModel
import com.deepertech.kotlinplaybmiapp.android.ui.main.views.components.StandardButton

@Composable
fun ResultsScreen(
    viewModel: BMIViewModel = BMIViewModel(),
    navigateToHome: () -> Unit = {}
) {
    val context = LocalContext.current

    val sendSmsLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // Handle the result of the SMS intent here
            if (result.resultCode == Activity.RESULT_OK) {
                // Handle the SMS sent
                println("SMS sent")
            }
        }

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


            BMIResult(viewModel)

            Spacer(modifier = Modifier.weight(.3f))

            BMICategory(viewModel)

            Spacer(modifier = Modifier.weight(.3f))


            BMIDetails(viewModel)

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

                    StandardButton("Share") {
                        // Check and request permission if not already granted
                        if (!hasPermission(context)) {
                            ActivityCompat.requestPermissions(
                                context as Activity,
                                arrayOf(android.Manifest.permission.SEND_SMS),
                                REQUEST_CODE_PERMISSIONS
                            )
                        }
                        var bmi = convertToStringWithOneDeciumalPlace(viewModel.getBmi())
                        var message = "I have a BMI of ${bmi}. What's yours?"

                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("smsto:")  // Only SMS apps respond to this.
                            putExtra(
                                "sms_body",
                                message
                            )
                            putExtra(
                                Intent.EXTRA_STREAM,
                                message
                            )
                        }
                        sendSmsLauncher.launch(intent)
                    }
                }
            }
        }


    }
}

@Composable
private fun BMIDetails(
    viewModel: BMIViewModel = BMIViewModel()
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
    viewModel: BMIViewModel = BMIViewModel()
) {
    Text(
        "Your BMI is " + viewModel.getBmiCategory(),
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Composable
private fun BMIResult(
    viewModel: BMIViewModel = BMIViewModel()
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

private fun hasPermission(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        android.Manifest.permission.SEND_SMS
    ) == PackageManager.PERMISSION_GRANTED
}


fun getHealthyWeightForHeight(viewModel: BMIViewModel): String {
    val healthyWeightForHeightUpper = viewModel.getHealthyWeightUpper()
    val healthyWeightForHeightLower = viewModel.getHealthyWeightLower()
    return "${convertToStringWithOneDeciumalPlace(healthyWeightForHeightLower)} - ${
        convertToStringWithOneDeciumalPlace(
            healthyWeightForHeightUpper
        )
    } kg"
}


private const val REQUEST_CODE_PERMISSIONS = 10

@Preview
@Composable
fun ResultsScreenPreview() {
    ResultsScreen()
}