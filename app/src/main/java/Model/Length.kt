package Model

import Model.Exceptions.IllegalValueException

/**
 * Created by AndyTsang on 2017-08-25.
 */
class Length : Converter() {
    private val units: Array<String>
    private val unitConversions: DoubleArray

    init {
        units = arrayOf("km", "m", "cm", "mm", "mi", "yd", "ft", "in")
        unitConversions = doubleArrayOf(1000.0, 1.0, 0.01, 0.001, 1609.344, 0.9144, 0.3048, 0.0254)
    }


    override fun unitsInfo() {
        println("    - Kilometer (km)")
        println("    - Meter (m)")
        println("    - Centimeter (cm)")
        println("    - Millimeter (mm)")
        println("    - Mile (mi)")
        println("    - Yard (yd)")
        println("    - Foot (ft)")
        println("    - Inch (in)")
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
