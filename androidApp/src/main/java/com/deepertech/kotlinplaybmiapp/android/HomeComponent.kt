package com.deepertech.kotlinplaybmiapp.android

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue

class HomeComponent (
    componentContext: ComponentContext,
    private val onNavigateToResultsScreen: (String) -> Unit
): ComponentContext by componentContext {
    private var _text = MutableValue("")
    val text = _text
    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.ClickResultsButton -> onNavigateToResultsScreen(text.value)
            is HomeEvent.UpdateText -> {
                _text.value = event.text
            }
        }
    }

}
