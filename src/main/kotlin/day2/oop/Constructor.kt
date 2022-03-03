package day2.oop

class Employee private constructor(firstName : String = "John"){

    var firstName : String? = null
    var lastName : String? = null
    val minimumAge : Int = 18
    constructor(firstName: String,lastName : String) : this(firstName){
        this.lastName = lastName
    }

    init{
        this.firstName = firstName
    }


    fun info () = "$firstName $lastName"

}


fun main(){


    val emp : Employee = Employee("Ron","Mathew")
    var age = emp.minimumAge
    println(age)
    println(emp.info())


}