package org.example.conversions

/**
 * Converts several different torque values such as Newton-meters, Foot Pounds and Inch Pounds.
 * @param value The value to be converted
 * @param fromUnit The unit that is being converted from.
 * @param toUnit The unit that is being converted to.
 * @return Returns a double that is the newly converted value.
 * @throws IllegalArgumentException if an unsupported unit is used.
 */
fun convertTorque(value: Double, fromUnit: String, toUnit: String): Double {
    val nmToLbFt = 0.73756 // 1 Newton-meter to Foot Pounds
    val lbFtToNm = 1.35582 // 1 Foot pound to Newton Meter
    val ftLbToIn = 12 // 1 Foot pound is 12 inch pounds
    val inLbToFt = 12 // 1 Inch pound to Foot pounds

    return when {
        //Newton-Meters to Foot Pounds
        fromUnit == "Nm" && toUnit == "ft-lb" -> value * nmToLbFt
        //Foot Pounds to Newton-Meters
        fromUnit == "ft-lb" && toUnit == "Nm" -> value * lbFtToNm
        //Inch Pounds to Foot Pounds
        fromUnit == "in-lb" && toUnit == "ft-lb" -> value / inLbToFt
        //Foot Pounds to Inch Pounds
        fromUnit == "ft-lb" && toUnit == "in-lb" -> value * ftLbToIn
        else -> throw IllegalArgumentException("Unsupported torque: $fromUnit")
    }
}


/**
 * Converts PSI and Bar.
 * @param value The value to be converted
 * @param fromUnit The unit that is being converted from.
 * @param toUnit The unit that is being converted to.
 * @return Returns a double that is the newly converted value.
 * @throws IllegalArgumentException if an unsupported unit is used.
 */
fun convertPressure(value: Double, fromUnit: String, toUnit: String): Double {
    val psiToBar = 0.06895
    val barToPsi = 14.5038

    return when {
        //PSI To Bar
        fromUnit == "psi" && toUnit == "bar" -> value * psiToBar
        // Bar to PSI
        fromUnit == "bar" && toUnit == "psi" -> value * barToPsi
        else -> throw IllegalArgumentException("Unsupported pressure: $fromUnit")
    }
}


/**
 * Calculates a gear ratio based on the driven teeth and amount of drive teeth.
 * @param drivenTeeth The amount of driven teeth on the gear turned by another gear.
 * @param driveTeeth The amount of teeth on the drive gear (MAIN GEAR)
 * @return Returns a double that is the newly converted value.
 * @throws IllegalArgumentException if an unsupported unit is used.
 */
fun calculateGearRatio(drivenTeeth: Int, driveTeeth: Int): Double {
    if (driveTeeth == 0) throw IllegalArgumentException("Drive Teeth cannot be zero")
    return drivenTeeth.toDouble() / driveTeeth.toDouble()
}


fun convertWeight(value: Double, fromUnit: String, toUnit: String): Double {
    return when {
        // Kilograms to Pounds
        fromUnit == "kg" && toUnit == "lb" -> value * 2.20462
        // Pounds to Kilograms
        fromUnit == "lb" && toUnit == "kg" -> value / 2.20462
        else -> throw IllegalArgumentException("Unsupported weight: $fromUnit")
    }
}


/**
 * Converts socket sizes, metric to imperial
 * @param value The value to be converted
 * @param fromUnit The unit that is being converted from.
 * @param toUnit The unit that is being converted to.
 * @return Returns a double that is the newly converted value.
 * @throws IllegalArgumentException if an unsupported unit is used.
 */
fun convertSocketSize(value: Double, fromUnit: String, toUnit: String): Double {
    return when {
        fromUnit == "mm" && toUnit == "in" -> value / 25.4
        fromUnit == "in" && toUnit == "mm" -> value * 25.4
        else -> throw IllegalArgumentException("Unsupported socket size: $fromUnit")
    }
}