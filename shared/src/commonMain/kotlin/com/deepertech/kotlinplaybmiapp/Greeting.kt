package com.deepertech.kotlinplaybmiapp

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!  I changed this."
    }
}