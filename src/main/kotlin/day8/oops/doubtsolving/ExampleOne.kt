package day8.oops.doubtsolving



interface Bag{
    fun stationary(){
        println("Bag contains stationary")
    }

}

class SchoolBag() : Bag{

    fun books(){
        println("Schoolbag contains books")
    }

}

class LaptopBag() : Bag{
    fun laptopAccessories(){
        println("LaptopBag contains laptop accessories")
    }
}


class Student(val bag : SchoolBag){}
class Employee(val bag : LaptopBag)


fun main() {
    val stud : Student = Student(SchoolBag())
    stud.bag.stationary()
    stud.bag.books()


    val emp : Employee = Employee(LaptopBag())
    emp.bag.stationary()
    emp.bag.laptopAccessories()
}