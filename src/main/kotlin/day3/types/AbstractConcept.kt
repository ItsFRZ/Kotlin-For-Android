package day3.types


abstract class Person(private var name : String,private var age : Int){

    
    abstract fun doWork()
    fun greet(){
        println("Hello $name")

    }

}

class Student(val name : String,val age : Int, val college : String) : Person(name,age){

    override fun doWork() {
        println("$name is studying")
    }

}



fun main(){

    val stud : Person = Student("Faraz",21,"GHRU")
    stud.doWork()

}
