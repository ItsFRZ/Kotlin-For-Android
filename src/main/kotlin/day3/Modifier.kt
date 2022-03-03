
package day3

class Student private constructor(firstName : String){

    private var firstName : String? = null
    private var lastName : String? = null

    init{
        this.firstName = firstName
    }

    public constructor(firstName: String,lastName : String) : this(firstName){
        this.lastName = lastName
    }

    public fun info() : Unit{
        println("Student name is $firstName $lastName")
    }

}

fun main(){

    val stud : Student = Student("Faraz","Sheikh")
    stud.info()

}