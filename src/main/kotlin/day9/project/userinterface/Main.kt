package day9.project.userinterface

import day9.project.controller.PersistRegisteredUser
import day9.project.model.Admin
import day9.project.model.Customer
import day9.project.model.Seller
import day9.project.security.auth.AdminSignup
import day9.project.security.auth.CustomerSignup
import day9.project.security.auth.SellerSignup
import day9.project.security.validation.AdminRegistrationValidation

import day9.project.security.validation.CustomerRegistrationValidation
import day9.project.security.validation.SellerRegistrationValidation

fun main() {

    run();

}


fun run(){
    println("Press 1 For Login")
    println("Press 2 For Registration")
    println("Press 3 For Exit")
    var input : Int? = null
    try{
        input = readLine()?.toInt() ?: 3
    }catch(e : Exception){
        println(e)
        println("Do you want to continue (Y/N)")
        val cont = readLine().toString()
        if(continueCheck(cont))
            run()
    }

    when(input){
        1 -> {

        }
        2 -> {
            registrationType();
        }
        else -> {
            println("Do you want to continue (Y/N)")
            val cont = readLine().toString()
            if(continueCheck(cont))
                run()
        }
    }


}

fun registrationType() {

    println("Press 1 For Customer Registration")
    println("Press 2 For Admin Registration")
    println("Press 3 For Restaurant Owner Registration")
    println("Press any other number to Back")
    var input : Int? = null
    try{
         input = readLine()?.toInt() ?: 3
    }catch(e : Exception){
        println(e)
        println("Do you want to continue")
        val cont = readLine().toString()
        if(continueCheck(cont))
            registrationType()
    }
    when(input){
        1 -> {
            customerRegistration()
        }
        2 -> {
            adminRegistration()
        }
        3 -> {
            sellerRegistration()
        }
        else -> {
            return
        }
    }



}

fun sellerRegistration() {

    println("Create your Username")
    val username  = readLine().toString()
    println("Enter your Email")
    val email  = readLine().toString()
    println("Create your Password")
    val password  = readLine().toString()

    val seller = Seller(username,email,password);
    val sellerValidation = SellerRegistrationValidation()
    val sellerSignup = SellerSignup()
    val persist = PersistRegisteredUser()
    if(sellerSignup.register(sellerValidation,seller)){
        persist.saveSeller(sellerSignup,sellerValidation,seller)
    }else{
        sellerRegistrationContinueMessage()
    }
}

fun sellerRegistrationContinueMessage() {

    println("Do you want to continue (Y/N)")
    val cont = readLine().toString()
    if(continueCheck(cont))
        sellerRegistration()
    else
        return
}

fun adminRegistration() {


    println("Create your Username")
    val username  = readLine().toString()
    println("Enter your Email")
    val email  = readLine().toString()
    println("Create your Password")
    val password  = readLine().toString()

    val admin = Admin(username,email,password);
    val adminValidation = AdminRegistrationValidation()
    val adminSignup = AdminSignup()
    val persist = PersistRegisteredUser()
    if(adminSignup.register(adminValidation,admin)){
        persist.saveAdmin(adminSignup,adminValidation,admin)
    }else{
        adminRegistrationContinueMessage()
    }




}

fun adminRegistrationContinueMessage() {

    println("Do you want to continue (Y/N)")
    val cont = readLine().toString()
    if(continueCheck(cont))
        adminRegistration()
    else
        return
}

fun customerRegistration() {

    println("Create your Username")
    val username  = readLine().toString()
    println("Enter your Email")
    val email  = readLine().toString()
    println("Create your Password")
    val password  = readLine().toString()

    val customer : Customer = Customer(username,email,password);
    val customerValidation = CustomerRegistrationValidation()
    val customerSignup = CustomerSignup()
    val persist = PersistRegisteredUser()
    if(customerSignup.register(customerValidation,customer)){
        persist.saveCustomer(customerSignup,customerValidation,customer)
    }else{
        customerRegistrationContinueMessage()
    }



}

fun customerRegistrationContinueMessage() {

    println("Do you want to continue (Y/N)")
    val cont = readLine().toString()
    if(continueCheck(cont))
        customerRegistration()
    else
        return

}

fun continueCheck(input : String) : Boolean {
    if(input.equals("y") || input.equals("Yes") || input.equals("Y") || input.equals("yes"))
        return true
    return false
}

