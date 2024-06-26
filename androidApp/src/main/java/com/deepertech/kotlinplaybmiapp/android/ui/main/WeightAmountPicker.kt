package com.deepertech.kotlinplaybmiapp.android.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeightAmountPicker(
    modifier: Modifier = Modifier,
    viewModel: BMIViewModel = viewModel()
) {
    // For now, just a simple text field.
    // Allow only numbers from 1 to 99.
    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .clickable(enabled = true) {
                viewModel.updateGender()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Text("Weight")
            OutlinedTextField(
                value = viewModel.weight.value.toString(),
                onValueChange = {
                    viewModel.updateWeight(it)
                },
                label = { if (viewModel.isWeightInKg.value) Text("kg") else Text("lb")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}



@Preview
@Composable
fun WeightAmountPickerPreview() {
    WeightAmountPicker()
}