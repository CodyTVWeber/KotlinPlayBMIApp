package com.deepertech.kotlinplaybmiapp.android

import BMIViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HeightAmountPicker(
    modifier: Modifier = Modifier,
) {
    val bmiViewModel: BMIViewModel = viewModel()
    Box (
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        // TODO: Implement CountPicker
//            CountPicker (bottomNumber = 1, topNumber = 300, defaultNumber = 160) {
        val selectedHeightUnit = if (bmiViewModel.isHeightInCm.value) "cm" else "ft"
        val amountFromCountPicker = bmiViewModel.height.intValue
        Text("$amountFromCountPicker $selectedHeightUnit")
    }

    // TODO:  Change to a SlidingNumberPicker
//    var sliderValue = 50.0f
//    Slider(
//        value = sliderValue,
//        onValueChange = { sliderValue = it },
//        valueRange = 0f..100f,
//        onValueChangeFinished = {
//            // Optional: callback when the user finishes interacting with the slider
//        }
//    )
}

@Preview
@Composable
fun HeightAmountPickerPreview() {
    HeightAmountPicker()
}