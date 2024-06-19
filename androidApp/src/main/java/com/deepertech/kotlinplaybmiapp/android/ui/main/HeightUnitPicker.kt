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
fun HeightUnitPicker(
    modifier: Modifier = Modifier,
    viewModel: BMIViewModel = viewModel()) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .clickable(enabled = true) {
                viewModel.updateHeightUnit()
            },
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        item {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Height Icon"
            )
            Text("Height")
            Row {
                Text(
                    "cm",
                    modifier = Modifier.padding(4.dp),
                    color = if (viewModel.isHeightInCm.value) Color.White else Color.LightGray
                )
                Text(
                    "ft",
                    modifier = Modifier.padding(4.dp),
                    color = if (!viewModel.isHeightInCm.value) Color.White else Color.LightGray
                )
            }
        }
    }
}

@Preview
@Composable
fun HeightUnitPickerPreview() {
    HeightUnitPicker()
}