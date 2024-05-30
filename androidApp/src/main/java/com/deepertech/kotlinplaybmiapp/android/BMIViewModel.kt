package com.deepertech.kotlinplaybmiapp.android

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

val bmiCategories = mapOf(
    "Underweight" to 19.0,
    "Normal weight" to 25.0,
    "Overweight" to 30.0,
    "Obesity" to Double.MAX_VALUE
)
data class BMIState(
    var height: Int = 170,
    var weight: Int = 70,
    var isHeightInCm: Boolean = true,
    var isWeightInKg: Boolean = true,
)
class BMIViewModel() : ViewModel() {
    // TODO:  Fix the ViewModel state
    // Expose screen UI state
    private val _bmiState = MutableStateFlow(BMIState())
    val bmiState: StateFlow<BMIState> = _bmiState.asStateFlow()


    fun changeHeight(height: Int) {
        _bmiState.update { currentState ->
            currentState.copy(height = height)
        }
    }

    fun changeWeight(weight: Int) {
        _bmiState.update { currentState ->
            currentState.copy(weight = weight)
        }
    }

    fun changeHeightUnit(isHeightInCm: Boolean) {
        _bmiState.update { currentState ->
            currentState.copy(isHeightInCm = isHeightInCm)
        }
    }

    fun changeWeightUnit(isWeightInKg: Boolean) {
        _bmiState.update { currentState ->
            currentState.copy(isWeightInKg = isWeightInKg)
        }
    }


    fun getBmi(): Double {
        val height = bmiState.value.height
        val weight = bmiState.value.weight
        val heightInM = if (bmiState.value.isHeightInCm) height / 100.0 else height * 0.3048
        val weightInKg = if (bmiState.value.isWeightInKg) weight else weight * 0.453592
        val heightSquared = heightInM * heightInM
        return weightInKg.toDouble() / heightSquared
    }

    fun getBmiCategory(): String {
        val bmi = getBmi()
        return when {
            bmi < bmiCategories.get("Underweight")!! -> "Underweight"
            bmi < bmiCategories.get("Normal weight")!! -> "Normal weight"
            bmi < bmiCategories.get("Overweight")!! -> "Overweight"
            else -> "Obesity"
        }
    }
}
