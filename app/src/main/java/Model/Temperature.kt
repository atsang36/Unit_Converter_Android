package Model

import Model.Exceptions.IllegalValueException

/**
 * Created by AndyTsang on 2017-08-25.
 */
class Temperature : Converter() {
    private val units: Array<String>? = null
    private val unitConversions: DoubleArray? = null

    override fun unitsInfo() {
        println("    - Celsius (c)")
        println("    - Fahrenheit (f)")
        println("    - Kelvin (k)")
        println()
    }

    @Throws(IllegalValueException::class)
    override fun convert(): Double {
        val from = from
        val to = to
        var value = value!!

        if (!isValidUnit(from!!, to!!)) {
            throw IllegalValueException()
        }

        if (from == "c") {
            value += 273.15

        } else if (from == "f") {
            value = (value - 32) * 5 / 9 + 273.15

        }

        if (to == "c") {
            value -= 273.15
        } else if (to == "f") {
            value = (value - 273.15) * 9 / 5 + 32
        }

        return value

    }

    override fun isValidUnit(from: String, to: String): Boolean {
        return if ((from == "c" || from == "f" || from == "k") && (to == "f" || to == "c" || to == "k")) {
            true
        } else
            false
    }


}
