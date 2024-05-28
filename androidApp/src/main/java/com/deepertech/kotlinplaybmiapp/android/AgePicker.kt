package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AgePicker() {
    Column {
        Text("Age")
//        CountPicker(bottomNumber = 1, topNumber = 120, defaultNumber = 25){
//            Text("$it")
//        }
    }
}

@Preview
@Composable
fun AgePickerPreview() {
    AgePicker()
}