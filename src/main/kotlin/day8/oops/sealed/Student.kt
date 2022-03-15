package day8.oops.sealed

import java.net.URI


sealed class Student(){
    fun secret(){
        println("Secret Function")
    }
}

class UnderGraduate() : Student(){
}
class PostGraduate() : Student(){}
class Doctrate() : Student(){}

