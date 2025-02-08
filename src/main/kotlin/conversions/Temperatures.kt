package org.example.conversions

fun convertTemperature(value: Double, fromUnit: String, toUnit: String): Double {
    return when {
        //Celsius to Fahrenheit
        fromUnit == "C" && toUnit == "F" -> (value * 9/5) + 32
        //Fahrenheit to Celsius
        fromUnit == "F" && toUnit == "C" -> (value - 32) * 5/9
        //Celsius to Kelvin
        fromUnit == "C" && toUnit == "K" -> value + 273.15
        //Kelvin to Celsius
        fromUnit == "K" && toUnit == "C" -> value - 273.15
        //Fahrenheit to Kelvin (Converts to Celsius in between)
        fromUnit == "F" && toUnit == "K" -> (value - 32) * 5/9 + 273.15
        //Kelvin to Fahrenheit
        fromUnit == "K" && toUnit == "F" -> (value - 273.15) * 9/5 + 32
        else -> throw IllegalArgumentException("Unsupported unit: $fromUnit")
    }
}