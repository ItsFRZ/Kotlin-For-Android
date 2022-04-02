package day14.userinterface

import day14.authentication.Validation
import day14.contoller.Login
import day14.contoller.Signup
import day14.contoller.ValidateRegistration


import day14.model.registration.*
import kotlin.system.exitProcess


class Authentication(){


    private val userRegistration : UserRegistration = UserRegistration("","","","","");
    private var isLoggedIn : Boolean= false


    fun isLoggedIn() : Boolean = isLoggedIn

    fun logout (){
        this.isLoggedIn = false
    }


    private fun setLoggedUser(user : UserRegistration){

        val(contactId,username,contactType,password,email) = user
        userRegistration.apply {
            this.contactId = contactId
            this.username = username
            this.contactType = contactType
            this.password = password
            this.email = email
        }
    }

    fun getLoggedUser() : UserRegistration{
        return this.userRegistration;
    }

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

        val validateAll = ValidateRegistration();

        println("Create your Username")
        val username  = readLine().toString()
        println("Enter your Email")
        val email  = readLine().toString()
        println("Create your Password")
        val password  = readLine().toString()

        if (!validateAll.passwordValidate(password)) {
            validateAll.invalidPassword()
            signupUser()
            return;
        }

        val contactType : String = setContactMode(username)


        // validation

        val signup = Signup(username,contactType,password,email);
        val isRegistered = signup.isRegistered()

        if (isRegistered)
        {
            println("$username your registration completed !")
        }else{
            println("Something went wrong :(")
        }

    }

    fun setContactMode(username: String): String {
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
                setContactMode(username);
            }
        }
        return usermode;
    }

    fun loginUser() {

        println("Enter your registered Username")
        val username = readLine().toString()
        println("Enter your registered Password")
        val password = readLine().toString()

        val login = Login(username,password);
        val isValidated = login.validateLoginCredentials();
        var user : UserRegistration? = null;
        if(isValidated){
            user = login.login();
        }else{
            println("Invalid Credentials!")
            return;
        }



        if (!user.equals("") && user!!.username.equals(username)) {
            println("$username you are logged in! Successfully :)\nUserType : ${user.contactType}")
            isLoggedIn = true;
            setLoggedUser(user);
        } else {
            println("Invalid Credentials!")
        }

    }



}





