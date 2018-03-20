package Model

import Model.Exceptions.IllegalValueException

/**
 * Created by AndyTsang on 2017-08-25.
 */
class Mass : Converter() {
    private val units: Array<String>
    private val unitConversions: DoubleArray

    init {
        units = arrayOf("ton", "kg", "g", "mg", "lb", "oz")
        unitConversions = doubleArrayOf(1000.0, 1.0, 0.001, 0.000001, 0.45359237, 0.0283495)
    }

    override fun unitsInfo() {
        println("    - Metric ton (ton)")
        println("    - Kilogram (kg)")
        println("    - Gram (g)")
        println("    - Milligram (mg)")
        println("    - Pound (lb)")
        println("    - Ounce (oz)")
    }

    @Throws(IllegalValueException::class)
    override fun convert(): Double {

        val from = from
        val to = to
        var value = value!!
        var indexFrom = -1
        var indexTo = -1

        for (i in units.indices) {
            if (from == units[i]) {
                indexFrom = i
            }

            if (to == units[i]) {
                indexTo = i
            }
        }
        if (indexFrom == -1 || indexTo == -1) {
            throw IllegalValueException()
        }
        value = value * unitConversions[indexFrom] / unitConversions[indexTo]

        return value
    }

    override fun isValidUnit(from: String, to: String): Boolean {
        return false
    }
}

