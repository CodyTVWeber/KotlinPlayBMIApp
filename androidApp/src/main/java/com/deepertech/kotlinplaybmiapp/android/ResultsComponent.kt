package com.deepertech.kotlinplaybmiapp.android

import com.arkivanov.decompose.ComponentContext

class ResultsComponent (
    val testText: String,
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {
    fun goBack() {
        onGoBack()
    }
}
