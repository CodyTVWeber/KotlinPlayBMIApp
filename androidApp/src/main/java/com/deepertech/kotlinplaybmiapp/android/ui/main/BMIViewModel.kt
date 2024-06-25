package com.deepertech.kotlinplaybmiapp.android.ui.main

import android.os.Parcelable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize

val bmiCategories = mapOf(
    "Underweight" to 19.0,
    "Normal weight" to 25.0,
    "Overweight" to 30.0,
    "Obesity" to Double.MAX_VALUE
)

@Parcelize
data class BMIState(
    var height: Int = 170,
    var weight: Int = 70,
    var isHeightInCm: Boolean = true,
    var isWeightInKg: Boolean = true,
    var isMale: Boolean = true,
    var age: Int = 30
) : Parcelable

class BMIViewModel : ViewModel() {
    var height = mutableIntStateOf(170)
    var weight = mutableIntStateOf(70)
    var isHeightInCm = mutableStateOf(true)
    var isWeightInKg = mutableStateOf(true)
    var isMale = mutableStateOf(true)
    var age = mutableIntStateOf(30)


    fun updateHeight(height: Int) {
        this.height.value = height
    }

    fun updateWeight(weight: Int) {
        this.weight.value = weight
    }

    fun updateHeightUnit() {
        isHeightInCm.value = isHeightInCm.value.not()
    }

    fun updateWeightUnit() {
        isWeightInKg.value = isWeightInKg.value.not()
    }

    fun updateGender() {
        isMale.value = isMale.value.not()
    }

    fun updateAge(age: Int) {
        this.age.value = age
    }

    fun getBmi(): Double {
        val height = height.value
        val weight = weight.value
        val heightInM = if (isHeightInCm.value) height / 100.0 else height * 0.3048
        val weightInKg = if (isWeightInKg.value) weight else weight * 0.453592
        val heightSquared = heightInM * heightInM
        return weightInKg.toDouble() / heightSquared
    }

    fun getBmiCategory(): String {
        val bmi = getBmi()
        return when {
            bmi < bmiCategories["Underweight"]!! -> "Underweight"
            bmi < bmiCategories["Normal weight"]!! -> "Normal weight"
            bmi < bmiCategories["Overweight"]!! -> "Overweight"
            else -> "Obesity"
        }
    }
}