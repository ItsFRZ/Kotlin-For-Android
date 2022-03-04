package day4.practice

import java.util.*

open class Department(val email : String,val password : String) : Authentication() ,User{

    var isLoggedIn : Boolean = false
    private val category = mutableMapOf<String,List<String>>()

    init{
        if(!authenticateCredentials(email,password))
            println("Your credentials are wrong")
        else
            isLoggedIn = true

    }


    fun getCars() : Map<String,List<String>>{
        return category;
    }

    public fun addCar() : Unit{
        if(!isLoggedIn){
            println("You are not authenticated")
            return
        }
        val obj = Scanner(System.`in`)
        println("Enter Carname ?")
        val carName = obj.nextLine()
        println("Enter $carName company name ?")
        val carCompany = obj.nextLine()
        println("Enter $carName category ?")
        val carCategory = obj.nextLine()
        println("Enter $carName price ?")
        val carPrice = obj.nextLine()
        addCar(carName,carCompany,carCategory,carPrice)


    }

    private fun addCar(carName : String,carCompany : String, carCategory: String ,carPrice : String){
        val addInList = mutableListOf<String>()
        addInList.add(carName)
        addInList.add(carCompany)
        addInList.add(carCategory)
        addInList.add(carPrice)
        category.put(carName,addInList);
        println("Car $carName added successfully")
    }

}