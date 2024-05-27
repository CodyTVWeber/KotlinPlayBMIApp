package com.deepertech.kotlinplaybmiapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }


}

@Composable
private fun App() {
    val navController = rememberNavController()


    MyApplicationTheme(
        darkTheme = true
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) { HomeScreen{
                    navController.navigate(Screen.Results.route)
                } }
                composable(Screen.Results.route) {
                    ResultsScreen {
                        navController.navigate(Screen.Home.route)
                    }
                }
            }
        }
    }
}

@Composable
fun ResultsScreen(navigateToHome: () -> Unit = {}) {
    Button(onClick = navigateToHome) {
        Text("Go to Home Screen")
    }
}

@Composable
fun HomeScreen(navigateToResults: () -> Unit = {}){
    Button(onClick = navigateToResults) {
        Text("Go to Results Screen")
    }
}

@Preview
@Composable
fun DefaultPreview() {
    App()
}
