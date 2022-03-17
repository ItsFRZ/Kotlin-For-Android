package day9.project.userinterface

import day9.project.controller.AuthenticateRegisteredAdmin
import day9.project.controller.AuthenticateRegisteredSeller
import day9.project.controller.AuthenticateRegisteredUser
import day9.project.controller.PersistRegisteredUser
import day9.project.model.users.Admin
import day9.project.model.users.Customer
import day9.project.model.users.Seller
import day9.project.security.auth.*
import day9.project.security.validation.AdminValidation
import day9.project.security.validation.CustomerValidation
import day9.project.security.validation.SellerValidation


private val customerValidation = CustomerValidation()
private val adminValidation = AdminValidation()
private val sellerValidation = SellerValidation()

var currentUser : String = "";



fun authUI() {

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
            authUI()
    }

    when(input){
        1 -> {
            loginType();
        }
        2 -> {
            registrationType();
        }
        else -> {
            continueRun();
        }
    }



}

private fun continueRun() {
    println("Do you want to continue (Y/N)")
    val cont = readLine().toString()
    if(continueCheck(cont))
        authUI()
}

fun loginType() {

    println("Press 1 For Customer")
    println("Press 2 For Admin")
    println("Press 3 For Restaurant Owner")
    println("Press any other number to Back")
    var input : Int? = null
    try{
        input = readLine()?.toInt() ?: 3
    }catch(e : Exception){
        println(e)
        println("Do you want to continue (Y/N)")
        val cont = readLine().toString()
        if(continueCheck(cont))
            loginType()
    }

    when(input){
        1 -> {
            customerLogin()
        }
        2 -> {
            adminLogin()
        }
        3 -> {
            sellerLogin()
        }
        else -> {
            authUI()
        }
    }

}

fun sellerLogin() {
    println("Enter your registered Username")
    val username  = readLine().toString()
    println("Enter your registered Password")
    val password  = readLine().toString()

    val sellerLogin = SellerLogin(username,password);
    if(sellerLogin.login(sellerValidation)){
        val auth = AuthenticateRegisteredSeller(username,password);
        if(auth.checkSellerCredentials())
        {
            isSellerLoggedIn = true
            currentUser = username
            println("Login Successfull :)")
        }else
        {
            println("Invalid Credentials")
        }
    }else{
        sellerLoginContinueMessage()
    }
}

fun sellerLoginContinueMessage() {
    println("Do you want to continue (Y/N)")
    val cont = readLine().toString()
    if(continueCheck(cont))
        sellerLogin()
    else
        return
}

fun adminLogin() {

    println("Enter your registered Username")
    val username  = readLine().toString()
    println("Enter your registered Password")
    val password  = readLine().toString()

    val adminLogin = AdminLogin(username,password);
    if(adminLogin.login(adminValidation)){
        val auth = AuthenticateRegisteredAdmin(username,password);
        if(auth.checkAdminCredentials())
        {
            isAdminLoggedIn = true
            currentUser = username

            println("Login Successfull :)")
        }else
        {
            println("Invalid Credentials")
        }
    }else{
        adminLoginContinueMessage()
    }
}

fun adminLoginContinueMessage() {
    println("Do you want to continue (Y/N)")
    val cont = readLine().toString()
    if(continueCheck(cont))
        adminLogin()
    else
        return
}

fun customerLogin() {

    println("Enter your registered Username")
    val username  = readLine().toString()
    println("Enter your registered Password")
    val password  = readLine().toString()

    val customerLogin = CustomerLogin(username,password);
    if(customerLogin.login(customerValidation)){
        val auth = AuthenticateRegisteredUser(username,password);
        if(auth.checkCustomerCredentials())
        {
            isCustomerLoggedIn = true
            currentUser = username
            println("Login Successfull :)")
        }else
        {
            println("Invalid Credentials")
        }
    }else{
        customerLoginContinueMessage()
    }

}

fun customerLoginContinueMessage() {
    println("Do you want to continue (Y/N)")
    val cont = readLine().toString()
    if(continueCheck(cont))
        customerLogin()
    else
        return
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
        println("Do you want to continue (Y/N)")
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
            authUI()
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

