package com.deepertech.kotlinplaybmiapp.android.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeightUnitPicker(
    modifier: Modifier = Modifier,
    viewModel: BMIViewModel = viewModel()) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .clickable(enabled = true) {
                viewModel.updateWeightUnit()
            },
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        item {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Weight Icon"
            )
            Text("Weight")
            Row {
                Text(
                    "kg",
                    modifier = Modifier.padding(4.dp),
                    color = if (viewModel.isWeightInKg.value) Color.White else Color.LightGray
                )
                Text(
                    "lb",
                    modifier = Modifier.padding(4.dp),
                    color = if (!viewModel.isWeightInKg.value) Color.White else Color.LightGray
                )
            }
        }
    }
}

@Preview
@Composable
fun WeightUnitPickerPreview() {
    WeightUnitPicker()
}