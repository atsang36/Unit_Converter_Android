package Model

import Model.Exceptions.IllegalValueException

import java.util.HashMap
import java.util.InputMismatchException
import java.util.Scanner

/**
 * Created by AndyTsang on 2017-08-25.
 */
object UnitConverter {

    val MEASUREMENT: MutableMap<String, String>

    init {
        MEASUREMENT = HashMap()
        MEASUREMENT.put("temp", "temperature")
        MEASUREMENT.put("len", "length")
        MEASUREMENT.put("m", "mass")
        MEASUREMENT.put("spd", "speed")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = Scanner(System.`in`)
        val b = true

        intro()

        while (b) {
            val r = ""

            convert(input)
            println("Exiting Application, Goodbye!")
            //            System.out.print("Do you want to choose another type of measurement? Yes(y) or No(n)? ");
            //            r = input.nextLine();
            //
            //            while (!r.toLowerCase().startsWith("n") && !r.toLowerCase().startsWith("y")) {
            //                System.out.println("Please choose Yes(y) or No(n)!");
            //                System.out.print("Do you want to choose another type of measurement? Yes(y) or No(n)? ");
            //                r = input.nextLine();
            //            }
            //
            //            if (r.toLowerCase().startsWith("n")) {
            //                b = false;
            //            }
        }
    }

    private fun intro() {
        println()
        println(" Please Enter The Type Of Measurement To Convert")
        println()
    }

    fun getConverter(input: Scanner): Converter? {
        var converter = ""
        val converterFactory = ConverterFactory()
        println("From the Following: ")
        println("    - Temperature (temp)")
        println("    - Length (len)")
        println("    - Mass (m)")
        println("    - Speed (spd)")
        println()

        converter = input.nextLine()
        while (!MEASUREMENT.containsKey(converter)) {
            println("Please Select The Choices Listed Above")
            converter = input.nextLine()
        }

        return converterFactory.getConverter(MEASUREMENT[converter])
    }

    fun convert(input: Scanner) {
        val converter = getConverter(input)
        val temp = true

        while (temp) {
            var r = ""

            println("Choose From: ")
            converter!!.unitsInfo()


            try {
                converter.giveInput()
                System.out.printf("The value after conversion is %.3f", converter.convert())
                println()
            } catch (e: IllegalValueException) {
                println("Please Enter Applicable Units")
            } catch (e: InputMismatchException) {
                println("Amount Needs to be a Number")
            }

            print("Do you want to convert another unit? Yes(y) or No(n)? ")
            r = input.nextLine()

            while (!r.toLowerCase().startsWith("n") && !r.toLowerCase().startsWith("y")) {
                println("Please enter Yes(y) or No(n)!")
                print("Do you want to convert another unit? Yes(y) or No(n)? ")
                r = input.nextLine()
            }

            if (r.toLowerCase().startsWith("n")) {
                //                temp = false;
                break
            }

        }
    }
}
