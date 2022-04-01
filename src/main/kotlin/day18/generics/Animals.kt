package day18

abstract class Animals(val size  : Int)

class Dog(cuteness : Int,size : Int) : Animals(size)

class Spider(terrorFactor : Int,size : Int) : Animals(size)


fun main() {


//    val myPet : Animals = Dog(100,12)


    val students : MutableList<Student> = mutableListOf(Student(),Student(),Student(),Student())
//    val person : MutableList<Person> = students;


}


open class Person()

class Student() : Person()



/************************************************************************************************/

//// Why generics are invariant
//
//
//open class Human(val name : String)
//class Employee(name : String) : Human(name)
//class Teacher(name : String) : Human(name)
//
//
//fun main() {
//
//    val emps : MutableList<Employee> = mutableListOf()
//    val teacher : Teacher = Teacher("John")
//    add(emps,teacher);
//
//
////    val emp1 : Employee = emps.get(0)
//
//}
//
//fun add(group : MutableList<Human>,human: Human) = group.add(human)



