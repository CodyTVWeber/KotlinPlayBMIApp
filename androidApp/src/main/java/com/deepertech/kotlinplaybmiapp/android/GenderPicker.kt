package com.deepertech.kotlinplaybmiapp.android

import BMIViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GenderPicker(
    modifier: Modifier = Modifier,
    viewModel: BMIViewModel = viewModel()
) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .clickable(enabled = true) {
                viewModel.updateGender()
            },
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        item {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Gender Icon")
            Row {
                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    "Male",
                    modifier = Modifier.padding(4.dp),
                    color = if (viewModel.isMale.value) Color.White else Color.LightGray
                )


                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    "Female",
                    modifier = Modifier.padding(4.dp),
                    color = if (!viewModel.isMale.value) Color.White else Color.LightGray
                )
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    }
}

@Preview
@Composable
fun GenderPickerPreview() {
    GenderPicker()
}