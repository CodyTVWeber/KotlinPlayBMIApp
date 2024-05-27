package com.deepertech.kotlinplaybmiapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ComponentContextFactory
import com.arkivanov.decompose.retainedComponent
import com.arkivanov.decompose.router.stack.items
import com.arkivanov.decompose.value.getValue
import com.arkivanov.essenty.backhandler.BackHandler
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.statekeeper.StateKeeper
import com.deepertech.kotlinplaybmiapp.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root =
        setContent {
            App(root)
        }
    }


}

@Composable
fun App(rootComponent: RootComponent) {
    BMICalculatorTheme(
        darkTheme = true
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            val childStack by rootComponent.childStack
            childStack.items.forEach { child ->
                when (child.instance) {
                    is RootComponent.Child.Home -> {
                        HomeScreen((child.instance as RootComponent.Child.Home).component)
                    }

                    is RootComponent.Child.Results -> {
                        ResultsScreen((child.instance as RootComponent.Child.Results).component)
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}
//
//@Preview
//@Composable
//fun DefaultPreview() {
//    val componentContext = object : ComponentContext {
//        override val backHandler: BackHandler
//            get() = TODO("Not yet implemented")
//        override val componentContextFactory: ComponentContextFactory<ComponentContext>
//            get() = TODO("Not yet implemented")
//        override val instanceKeeper: InstanceKeeper
//            get() = TODO("Not yet implemented")
//        override val lifecycle: Lifecycle
//            get() = TODO("Not yet implemented")
//        override val stateKeeper: StateKeeper
//            get() = TODO("Not yet implemented")
//    }
//    App(RootComponent(componentContext))
//}

