package Model

/**
 * Created by AndyTsang on 2017-08-25.
 */
class FuelConsumption : Converter() {
    override fun unitsInfo() {

    }

    override fun convert(): Double {
        return 0.0
    }

    override fun isValidUnit(from: String, to: String): Boolean {
        return false
    }
}
