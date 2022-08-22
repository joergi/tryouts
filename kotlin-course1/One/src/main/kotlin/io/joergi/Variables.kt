package io.joergi

import java.util.*

class Customer(val id: Int, var name: String, val yearOfBirth: Int){

    val age: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth

    var ssn: String = ""
        set(value) {
            field = value
        }
}

fun main(args: Array<String>) {

    val customer = Customer(10, "test", 1977)
    customer.ssn = "xxx"

    println(customer.ssn)


}
