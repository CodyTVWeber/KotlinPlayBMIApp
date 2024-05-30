package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

// TODO:  Fix the ViewModel state
@Composable
fun HeightUnitPicker(
    viewModel: BMIViewModel = viewModel()
) {
    val bmiState by viewModel.bmiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable(enabled = true) {
                viewModel.changeHeightUnit(!bmiState.isHeightInCm)
            },
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Height Icon"
        )
        Text("Height")
        // TODO:  Fix coloring
        Row {
            Text(
                "cm",
                modifier = Modifier.padding(4.dp),
//                        color = if(isHeightInCm) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                color = if (bmiState.isHeightInCm) Color.White else Color.LightGray
            )
            Text(
                "ft",
                modifier = Modifier.padding(4.dp),
//                        color = if(!isHeightInCm) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                color = if (!bmiState.isHeightInCm) Color.White else Color.LightGray
            )
        }
    }
}

@Preview
@Composable
fun HeightUnitPickerPreview() {
    HeightUnitPicker()
}