package com.deepertech.kotlinplaybmiapp.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GenderPicker() {
    Column {
        Text("Gender")
        Row {
//            Icon(
//                imageVector = androidx.compose.material3.icons.Icons.Filled.ArrowBack,
//                contentDescription = "Back"
//            )
            Spacer(modifier = Modifier.padding(8.dp, 0.dp))
//            DisplayMode.Picker{
//                Box {
//                    Icon(
//                        imageVector = androidx.compose.material3.icons.Icons.Filled.Female,
//                        contentDescription = "Female"
//                    )
//                    Text(text = "Female")
//                }
//                Box {
//                    Icon(
//                        imageVector = androidx.compose.material3.icons.Icons.Filled.Male,
//                        contentDescription = "Male"
//                    )
//                    Text(text = "Male")
//
//                }
//            }
            Spacer(modifier = Modifier.padding(8.dp, 0.dp))
//            Icon(
//                imageVector = androidx.compose.material3.icons.Icons.Filled.ArrowForward,
//                contentDescription = "Forward"
//            )
        }
    }
}

@Preview
@Composable
fun GenderPickerPreview() {
    GenderPicker()
}