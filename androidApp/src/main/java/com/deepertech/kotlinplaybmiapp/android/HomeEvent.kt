package com.deepertech.kotlinplaybmiapp.android

sealed interface HomeEvent {
    data object ClickResultsButton: HomeEvent
    data class UpdateText(val text: String): HomeEvent
}