package com.deepertech.kotlinplaybmiapp.android.ui.main.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

val bmiCategories = mapOf(
    "Underweight" to 19.0,
    "Normal Weight" to 25.0,
    "Overweight" to 30.0,
    "Obesity" to 40.0,
    "Severe Obesity" to Double.MAX_VALUE
)

class BMIViewModel : ViewModel() {
    var height by mutableStateOf("170")
        private set
    var weight by mutableStateOf("70")
        private set
    var isHeightInCm by mutableStateOf(true)
        private set
    var isWeightInKg by mutableStateOf(true)
        private set
    var isMale by mutableStateOf(true)
        private set
    var age by mutableStateOf("30")
        private set


    fun updateHeight(height: String) {
        this.height = height
    }

    fun updateWeight(weight: String) {
        this.weight = weight
    }

    fun updateHeightUnit() {
        isHeightInCm.not().also { isHeightInCm = it }
    }

    fun updateWeightUnit() {
        isWeightInKg = isWeightInKg.not()
    }

    fun updateGender() {
        isMale = isMale.not()
    }

    fun updateAge(age: String) {
        this.age = age
    }

    fun getBmi(): Double {
        val height = height.toDouble()
        val weight = weight.toDouble()
        val heightInM = if (isHeightInCm) height / 100.0 else height * 0.3048
        val weightInKg = if (isWeightInKg) weight else weight * 0.453592
        val heightSquared = heightInM * heightInM
        return weightInKg / heightSquared
    }

    fun getBmiCategory(): String {
        val bmi = getBmi()
        return when {
            bmi < bmiCategories["Underweight"]!! -> "Underweight"
            bmi < bmiCategories["Normal Weight"]!! -> "Normal Weight"
            bmi < bmiCategories["Overweight"]!! -> "Overweight"
            bmi < bmiCategories["Obesity"]!! -> "Obesity"
            else -> "Severe Obesity"
        }
    }

    fun getHealthyBmiRange(): String {
        return "18.5 - 24.9 kg/m2"
    }


    fun getHealthyWeightLower() = 18.5 * getHeightInM() * getHeightInM()

    fun getHealthyWeightUpper() = 24.9 * getHeightInM() * getHeightInM()

// TODO: Implement these functions correctly
//    fun getBMIPrime(): Double {
//        val height = height
//        val weight = weight
//        val heightInM = if (isHeightInCm) height / 100.0 else height * 0.3048
//        val weightInKg = if (isWeightInKg) weight else weight * 0.453592
//        val heightSquared = heightInM * heightInM
//        val bmi = weightInKg.toDouble() / heightSquared
//        val ponderalIndex = weightInKg.toDouble() / heightInM.pow(3.0)
//        val bmiPrime = bmi / (ponderalIndex.pow(2.0 / 3.0))
//        return bmiPrime
//    }
//
//    fun getPonderalIndex(): Double {
//        return weight.toDouble() / height.toDouble().pow(3.0)
//    }

    private fun getHeightInM(): Double {
        val height = height.toDouble()
        val heightInM = if (isHeightInCm) height / 100.0 else height * 0.3048
        return heightInM
    }
}