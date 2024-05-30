package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeightUnitPicker(isHeightInCm: Boolean) {
    // TODO:  Set up state for isHeightInCm
    Box(
        // TODO: Add on click to change the height unit
    ) {
        Column(
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
//                        color = if(isHeightInCm) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                    color = if (isHeightInCm) Color.White else Color.LightGray
                )
                Text(
                    "ft",
//                        color = if(!isHeightInCm) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                    color = if (!isHeightInCm) Color.White else Color.LightGray
                )
            }
        }

    }
}

@Preview
@Composable
fun HeightUnitPickerPreview() {
    HeightUnitPicker(isHeightInCm = true)
}