package com.deepertech.kotlinplaybmiapp.android

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Results : Screen("results")
}