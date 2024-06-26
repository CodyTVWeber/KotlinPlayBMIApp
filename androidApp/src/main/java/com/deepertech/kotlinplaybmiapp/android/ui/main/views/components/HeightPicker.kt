package com.deepertech.kotlinplaybmiapp.android.ui.main.views.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeightPicker() {
    Row {
        HeightUnitPicker(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        HeightAmountPicker(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(3f))
    }
}

@Preview
@Composable
fun HeightPickerPreview() {
    HeightPicker()
}