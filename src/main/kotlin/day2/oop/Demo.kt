package day2.oop


class Student{

    val school : String = "DP"
    var age : Int = 5

    val isTeenager : Boolean
        get() = age > 12

    var name : String? = null
        get() = field ?: "unknown"
        set(value){
            if(value != null) field = value
        }


}

fun main(){
    val obj1 : Student = Student();
    val obj2 : Student = Student();

    println(obj1.isTeenager)
    println(obj1.name)
    obj1.name = "Faraz"
    println(obj1.name)


}
