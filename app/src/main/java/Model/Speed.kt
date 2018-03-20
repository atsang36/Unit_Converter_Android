package Model

import Model.Exceptions.IllegalValueException

/**
 * Created by AndyTsang on 2017-08-25.
 */
class Speed : Converter() {
    private val units: Array<String>
    private val unitConversions: DoubleArray

    init {
        units = arrayOf("mph", "fps", "mps", "kph")
        unitConversions = doubleArrayOf(0.44704, 0.3048, 1.0, 0.27778)
    }

    override fun unitsInfo() {
        println("    - Mile/hour (mph)")
        println("    - Feet/second (fps)")
        println("    - Meter/second (mps)")
        println("    - Kilometer/hour (kph)")
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

