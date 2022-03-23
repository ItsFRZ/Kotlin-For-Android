package day14.userinterface

import day14.contoller.Login
import day14.contoller.Signup
import day14.contoller.UserSession
import day14.model.registration.*
import kotlin.system.exitProcess

var currentUser : String = "";
var isLogIn : Boolean = false


fun authUI() {

    println("Press 1 For Login")
    println("Press 2 For Registration")
    println("Press 3 For Exit")
    var input : Int? = null
    try{
        input = readLine()?.toInt() ?: 3
    }catch(e : Exception){
        println("Please enter numeric value")
        authUI()
    }

    when(input) {
        1 -> {
            loginUser();
        }
        2 -> {
            signupUser();
        }
        3 -> {
            exitProcess(1);
        }
        else -> {
            authUI()
        }
    }



}


fun signupUser() {
    println("Create your Username")
    val username  = readLine().toString()
    println("Enter your Email")
    val email  = readLine().toString()
    println("Create your Password")
    val password  = readLine().toString()
    val usermode :String = setUserMode(username)
    val isRegistered : Boolean = Signup(username,usermode,password,email).registerUser();
    if (isRegistered)
    {
        println("$username your registration completed !")
    }else{
        println("Something went wrong :(")
    }

}

fun setUserMode(username: String): String {
    println("$username select following usermode")
    println("Press 1 For Customer Mode")
    println("Press 2 For Seller Mode")
    println("Press 3 For Admin Mode")
    val choice: String? = readLine().toString() ?: "Null"
    var usermode : String = ""
    when (choice) {

        "1" -> {
            usermode =  UserMode.Customer.name
        }
        "2" -> {
            usermode =  UserMode.Seller.name
        }
        "3" -> {
            usermode =  UserMode.Admin.name
        }
        else -> {
            setUserMode(username);
        }
    }
    return usermode;
}



fun loginUser() {

    println("Enter your registered Username")
    val username = readLine().toString()
    println("Enter your registered Password")
    val password = readLine().toString()
    val isLoggedIn: Boolean = Login(username, password).login();
    if (isLoggedIn) {
        val userMode = getUserMode(username);
        currentUser = username
        println("$username you are logged in! Successfully :)\nUsermode : $userMode")
        isLogIn = true
    } else {
        println("Invalid credentials")
    }

}


fun getUserMode(username: String): String {
    return UserSession(username).userSession();
}





