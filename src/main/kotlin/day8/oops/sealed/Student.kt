package day8.oops.sealed

sealed class Student(){
    fun secret(){
        println("Secret Function")
    }
}

class UnderGraduate() : Student(){
}
class PostGraduate() : Student(){}
class Doctrate() : Student(){}

