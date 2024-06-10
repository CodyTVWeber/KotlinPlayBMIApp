package com.deepertech.kotlinplaybmiapp.android

import BMIViewModel2
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HeightAmountPicker(
    modifier: Modifier = Modifier,
) {
    var bmiViewModel: BMIViewModel2 = viewModel()
    Box (
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        // TODO: Implement CountPicker
//            CountPicker (bottomNumber = 1, topNumber = 300, defaultNumber = 160) {
        val selectedHeightUnit = if (bmiViewModel.isHeightInCm.value) "cm" else "ft"
        val amountFromCountPicker = bmiViewModel.height.value
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