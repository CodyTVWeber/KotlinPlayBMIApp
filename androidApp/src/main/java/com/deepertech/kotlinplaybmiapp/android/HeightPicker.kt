package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeightPicker() {
    Row {
        HeightUnitPicker()
        Spacer(
            modifier = Modifier.fillMaxWidth()
        )
        HeightAmountPicker()
    }
}

@Preview
@Composable
fun HeightPickerPreview() {
    HeightPicker()
}