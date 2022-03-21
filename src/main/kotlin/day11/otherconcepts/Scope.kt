package day11.otherconcepts



class Person{

    var name : String? = null
    var age : Int? = null

}

class Operations(no : Int){
    var number : Int = no;
}

infix fun Operations.add(no : Int){
    this.number += no

}

fun infixFunctionExample(){

    val opt = Operations(10)
    opt.add(10)
    opt.add(20)
    opt add 30
    println(opt.number)
}

fun main() {

////     Infix Function Example
//    infixFunctionExample();



//    val person = Person()
//    withScopePractice(person)
//    val personData = applyScopePractice(person)
//    println("Person name is ${personData.name} and age is ${personData.age}")

//    val numbers = mutableListOf<Int>(11,2,3,4,5,6,1)
//    withPrint(numbers)
//    alsoOperations(numbers)
//    withPrint(numbers)

//    val name : String? = "Hello World"
//    println(name)
//    name?.let{
//        println(it!!.reversed())
////        println(it!!.capitalize())
//    }


//    val person  : Person? = null
    val person  : Person? = Person()
    val personBio = person?.run {
        name = "Faraz"
        age = 22
        "Person name is ${this.name} and age is ${this.age}"
    }

    println(personBio ?: "")

}


fun alsoOperations(numbers: MutableList<Int>) {

    numbers.also {
        it.add(6)
        it.add(7)
        it.add(8)
        it.add(9)
        it.remove(11)
    }
}

fun withPrint(obj : Any){
    with(obj){
        println(obj)
    }
}

fun applyScopePractice(person: Person) : Person{

    return person.apply {
        this.name = "Faraz"
        this.age = 22
        return this
    }
}

fun withScopePractice(person: Person) {

    val name : String = with(person){
        this.name = "Faraz"
        this.age = 22
        println("Person name ${this.name} and age is ${this.age}")
        name ?: "Unknown"
    }

    println(name)
}
