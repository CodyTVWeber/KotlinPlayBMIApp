package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeightAmountPicker() {
    Box {
        // TODO: Implement CountPicker
//            CountPicker (bottomNumber = 1, topNumber = 300, defaultNumber = 160) {
        val selectedHeightUnit = "cm"
        val amountFromCountPicker = "160"
        Text("$amountFromCountPicker $selectedHeightUnit")
    }
}

@Preview
@Composable
fun HeightAmountPickerPreview() {
    HeightAmountPicker()
}