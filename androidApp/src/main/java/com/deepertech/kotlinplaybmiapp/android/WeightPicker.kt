package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WeightPicker() {
    // Similar as HeightPicker
    Row {
        Column {
//            Icon(
//                imageVector = androidx.compose.material3.icons.Icons.Filled.Weight,
//                contentDescription = "Weight"
//            )
            Text("Weight")
//            Selector {
//                Text("kg")
//                Text("lb")
//            }
        }

        Spacer(
            modifier = Modifier.fillMaxWidth()
        )
        Box {
//            CountPicker (bottomNumber = 1, topNumber = 500, defaultNumber = 55) {
//                    Text("$it $selectedWeightUnit")
        }
    }
}

@Preview
@Composable
fun WeightPickerPreview() {
    WeightPicker()
}