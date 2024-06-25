package com.deepertech.kotlinplaybmiapp.android.ui.main

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Results : Screen("results")
}