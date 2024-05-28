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
fun HeightPicker() {
    Row {
        Column {
//            Icon(
//                imageVector = androidx.compose.material3.icons.Icons.Filled.Height,
//                contentDescription = "Height"
//            )
            Text("Height")
//            Selector {
//                Text("cm")
//                Text("ft")
//            }
        }

        Spacer(
            modifier = Modifier.fillMaxWidth()
        )
        Box {
//            CountPicker (bottomNumber = 1, topNumber = 300, defaultNumber = 160) {
//                    Text("$it $selectedHeightUnit")
        }
    }
}

@Preview
@Composable
fun HeightPickerPreview() {
    HeightPicker()
}