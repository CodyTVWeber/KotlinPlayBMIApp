package com.deepertech.kotlinplaybmiapp.android

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()

    val childStack: Value<ChildStack<Configuration, Child>> = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.Home,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(configuration: Configuration, context: ComponentContext): Child =
        when (configuration) {
            is Configuration.Home -> Child.Home(
                HomeComponent(
                    componentContext = context,
                    onNavigateToResultsScreen = { text ->
                        navigation.pushNew(Configuration.ResultsScreen(testText = text))
                    }
                )
            )

            is Configuration.ResultsScreen -> Child.Results(
                ResultsComponent(
                    configuration.testText,
                    componentContext = context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )
        }

    sealed class Child {
        data class Home(val component: HomeComponent) : Child()
        data class Results(val component: ResultsComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable

        data object Home : Configuration()

        @Serializable

        data class ResultsScreen(val testText: String) : Configuration()
        companion object {
            fun serializer(): KSerializer<Configuration>? {
                return serializer()
            }
        }
    }
}