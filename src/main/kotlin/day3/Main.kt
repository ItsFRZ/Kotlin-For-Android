package day3

import java.net.Inet4Address


open class Person(name : String,age : String,address: String){

    private var name : String? = null
    private var age : String? = null
    private var address : String? = null

    init{
        println("Person is called")
        this.name = name
        this.age = age
        this.address = address
        info(name,age,address)
    }

    open fun info(name : String,age : String,address: String){
        println("Person Info")
        println("Name is $name, Age is $age and address is $address")
    }

}

class BusinessMan(private val name : String,private val age : String,private val address: String) : Person(name,age,address) {
    init{
        println("Business Men is Called")
    }

    override fun info(name : String,age : String,address: String){
        println("Business Men Info")
        println("Name is $name, Age is $age and address is $address")
    }
}

class Employee(var name : String,var age : String,var address: String) : Person(name,age,address){
    init{
        println("Employee is Called")
    }

}

fun main(){

//    val bobj = BusinessMan("Rob","43","San francisco")
//    bobj.info()

    val empObj = Employee("Ron","28","Netherlands")
    empObj.address = "Canada"
    empObj.info(empObj.name,empObj.age,empObj.address)


}