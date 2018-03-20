package Model

/**
 * Created by AndyTsang on 2017-08-25.
 */
class ConverterFactory {
    fun getConverter(measurementType: String): Converter? {
        if (measurementType == "temperature") {
            return Temperature()
        } else if (measurementType == "length") {
            return Length()
        } else if (measurementType == "mass") {
            return Mass()
        } else if (measurementType == "speed") {
            return Speed()
        }

        return null
    }
}
