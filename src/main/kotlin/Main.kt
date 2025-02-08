package org.example

import org.example.conversions.*

fun main() {
    println("Automotive Conversion Application")

    while(true) {
        println("\nChoose an Option:")
        println("1. Torque")
        println("2. Pressure")
        println("3. Gear Ratio")
        println("4. Temperature")
        println("5. Weight")
        println("6. Socket Size (mm<->in)")
        println("0. Exit")

        when(readlnOrNull()?.trim()) {
            "0" -> {
                println("Exiting...")
                return
            }
            "1" -> handleTorqueConversion()
            "2" -> handlePressureConversion()
            "3" -> handleGearRatio()
            "4" -> handleTemperatureConversion()
            "5" -> handleWeightConversion()
            "6" -> handleSocketSizeConversion()
        }
    }
}


/**
 * Handles the user interface for converting torque values.
 */
fun handleTorqueConversion() {
    println("\nEnter an option: ")
    println("0. Return to Main Menu")
    println("1. Newton-meters (Nm) -> Foot Pound (ft-lb)")
    println("2. Foot Pound (ft-lb) -> Newton-meters (Nm)")
    println("3. Inch Pounds (in-lb) -> Foot Pounds (ft-lb)")
    println("4. Foot Pounds (ft-lb) -> Inch Pounds (in-lb)")

    when (readlnOrNull()?.trim()) {
        "0" -> return
        "1" -> performTorqueConversion("Nm", "lb-ft")
        "2" -> performTorqueConversion("ft-lb", "Nm")
        "3" -> performTorqueConversion("in-lb", "ft-lb")
        "4" -> performTorqueConversion("ft-lb", "in-lb")
        else -> println("Invali choice")
    }
}


/**
 * Performs the torque conversion by utilizing the Conversions package.
 * @param fromUnit The unit to be converted from.
 * @param toUnit The unit to be converted to.
 */
fun performTorqueConversion(fromUnit: String, toUnit: String) {
    print("Enter value in $fromUnit: ")
    val value = readlnOrNull()?.toDoubleOrNull()

    if (value == null) {
        println("Invalid input")
        return
    }

    val result = try {
        convertTorque(value, fromUnit, toUnit)
    } catch (e: Exception) {
        println(e.message)
        return
    }
    println("\nConverted value: $result $toUnit")
}


/**
 * Handles the user interface for converting pressure values.
 */
fun handlePressureConversion() {
    println("\nEnter an option: ")
    println("0. Return to Main Menu")
    println("1. PSI (psi) -> Bar (bar)")
    println("2. Bar (bar) -> PSI (psi)")

    when (readlnOrNull()?.trim()) {
        "0" -> return
        "1" -> performPressureConversion("psi", "bar")
        "2" -> performPressureConversion("bar", "psi")
    }
}


/**
 * Performs the pressure conversion by utilizing the Conversions package.
 * @param fromUnit The unit to be converted from.
 * @param toUnit The unit to be converted to.
 */
fun performPressureConversion(fromUnit: String, toUnit: String) {
    print("Enter value in $fromUnit: ")
    val value = readlnOrNull()?.toDoubleOrNull()

    if (value == null) {
        println("Invalid input")
        return
    }

    val result = try {
        convertPressure(value, fromUnit, toUnit)
    } catch (e: Exception) {
        println(e.message)
        return
    }
    println("\nConverted value: $result $toUnit")
}


/**
 * Handles the user interface for calculating gear ratios.
 */
fun handleGearRatio() {
    print("Enter number of teeth on the driven gear: ")
    val numOfDrivenTeeth = readlnOrNull()?.toIntOrNull()
    print("Enter number of teeth on the drive gear: ")
    val driveTeeth = readlnOrNull()?.toIntOrNull()

    if (numOfDrivenTeeth == null || driveTeeth == null) {
        println("Invalid input. Please enter whole numbers only.")
        return
    }

    try {
        val ratio = calculateGearRatio(numOfDrivenTeeth, driveTeeth)
        println("Gear Ratio: $ratio : 1")
    } catch (e: Exception) {
        println(e.message)
    }
}


/**
 * Handles the user interface for converting temperature conversions.
 */
fun handleTemperatureConversion() {
    println("\nChoose an Option: ")
    println("0. Return to Main Menu")
    println("1. Celsius -> Fahrenheit")
    println("2. Fahrenheit -> Celsius")
    println("3. Celsius -> Kelvin")
    println("4. Kelvin -> Celsius")
    println("5. Fahrenheit -> Kelvin")
    println("6. Kelvin -> Fahrenheit")

    when (readlnOrNull()?.trim()) {
        "0" -> return
        "1" -> performTemperatureConversion("C", "F")
        "2" -> performTemperatureConversion("F", "C")
        "3" -> performTemperatureConversion("C", "K")
        "4" -> performTemperatureConversion("K", "C")
        "5" -> performTemperatureConversion("F", "K")
        "6" -> performTemperatureConversion("K", "F")
        else -> println("Invalid choice.")
    }
}


/**
 * Performs the temperature conversion by utilizing the Conversions package.
 * @param fromUnit The unit to be converted from.
 * @param toUnit The unit to be converted to.
 */
fun performTemperatureConversion(fromUnit: String, toUnit: String) {
    print("Enter value in $fromUnit: ")
    val value = readlnOrNull()?.toDoubleOrNull()

    if (value == null) {
        println("Invalid input.")
        return
    }

    try {
        val result = convertTemperature(value, fromUnit, toUnit)
        println("\nTemperature Conversion: $result")
    } catch (e: Exception) {
        println(e.message)
    }
}


/**
 * Handles the user interface for converting weight conversions.
 */
fun handleWeightConversion() {
    println("\nChoose an Option: ")
    println("0. Return to Main Menu")
    println("1. Kilograms -> Pounds")
    println("2. Pounds -> Kilograms")

    when (readlnOrNull()?.trim()) {
        "0" -> return
        "1" -> performWeightConversion("kg", "lb")
        "2" -> performWeightConversion("lb", "kg")
        else -> println("Invalid choice.")
    }
}


/**
 * Performs the weight conversion by utilizing the Conversions package.
 * @param fromUnit The unit to be converted from.
 * @param toUnit The unit to be converted to.
 */
fun performWeightConversion(fromUnit: String, toUnit: String) {
    print("Enter value in $fromUnit: ")
    val value = readlnOrNull()?.toDoubleOrNull()

    if (value == null) {
        println("Invalid input.")
        return
    }

    try {
        val result = convertWeight(value, fromUnit, toUnit)
        println("\nConverted weight: $result")
    } catch (e: Exception) {
        println(e.message)
    }
}


/**
 * Handles the user interface for converting socket sizes.
 */
fun handleSocketSizeConversion() {
    println("\nChoose an Option: ")
    println("0. Return to Main Menu")
    println("1. Millimeters -> Inches")
    println("2. Inches -> Millimeters")

    when (readlnOrNull()?.trim()) {
        "0" -> return
        "1" -> performSocketSizeConversion("mm", "in")
        "2" -> performSocketSizeConversion("in", "mm")
        else -> println("Invalid choice.")
    }
}


/**
 * Performs the socket size conversion by utilizing the Conversions package.
 * @param fromUnit The unit to be converted from.
 * @param toUnit The unit to be converted to.
 */
fun performSocketSizeConversion(fromUnit: String, toUnit: String) {
    print("Enter value in $fromUnit: ")
    val value = readlnOrNull()?.toDoubleOrNull()

    if (value == null) {
        println("Invalid input.")
        return
    }

    try {
        val result = convertSocketSize(value, fromUnit, toUnit)
        println("\nConverted size: $result")
    } catch (e: Exception) {
        println(e.message)
    }
}