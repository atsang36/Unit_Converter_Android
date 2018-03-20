package Model

import Model.Exceptions.IllegalValueException

import java.util.Scanner

/**
 * Created by AndyTsang on 2017-08-25.
 */
abstract class Converter {
    var from: String? = null
        private set
    var to: String? = null
        private set
    var value: Double? = null
        private set
    private val input: Scanner

    init {
        this.from = ""
        this.to = ""
        this.value = 0.0
        this.input = Scanner(System.`in`)
    }

    fun giveInput() {
        println("Enter unit to convert from: ")
        this.from = input.nextLine()
        println("Enter unit to convert to: ")
        this.to = input.nextLine()
        println("Enter the amount to convert: ")
        this.value = input.nextDouble()
        input.nextLine()
    }

    abstract fun unitsInfo()

    @Throws(IllegalValueException::class)
    abstract fun convert(): Double

    abstract fun isValidUnit(from: String, to: String): Boolean
}
