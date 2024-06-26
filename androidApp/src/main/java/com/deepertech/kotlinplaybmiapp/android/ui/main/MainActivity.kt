package com.deepertech.kotlinplaybmiapp.android.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deepertech.kotlinplaybmiapp.android.ui.main.viewmodels.BMIViewModel
import com.deepertech.kotlinplaybmiapp.android.ui.main.views.screens.HomeScreen
import com.deepertech.kotlinplaybmiapp.android.ui.main.views.screens.ResultsScreen
import com.deepertech.kotlinplaybmiapp.android.ui.main.views.screens.Screen

class MainActivity : ComponentActivity() {
    val viewModel = viewModels<BMIViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(viewModel = viewModel.value)
        }
    }


}

@Composable
private fun App(viewModel: BMIViewModel = BMIViewModel()) {
    val navController = rememberNavController()

    MyApplicationTheme(
        darkTheme = true
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) {
                    HomeScreen(viewModel = viewModel) {
                        navController.navigate(Screen.Results.route)
                    }
                }
                composable(Screen.Results.route) {
                    ResultsScreen(viewModel = viewModel) {
                        navController.navigate(Screen.Home.route)
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    App()
}
