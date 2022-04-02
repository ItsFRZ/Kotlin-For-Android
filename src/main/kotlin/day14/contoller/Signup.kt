package day14.contoller


import day14.authentication.Validation
import day14.handler.*
import day14.model.registration.User

import day14.model.registration.UserRegistration

class Signup(val username: String,val contactType: String,val password: String,val email: String){


    fun isRegistered() : Boolean{
        return registerUser(username,contactType,password,email);
    }



}


class ValidateRegistration(){
    private var validation = Validation()

    fun usernameValidate(username : String) : Boolean{
        return validation.validateUsername(username)
    }

    fun invalidUsername(){
        validation.usernameHelp()
    }

    fun emailValidate(email: String) : Boolean{
        return validation.validateEmail(email)
    }

    fun invalidEmail(){
        validation.emailHelp()
    }

    fun passwordValidate(password: String) : Boolean{
        return validation.validatePassword(password)
    }

    fun invalidPassword(){
        validation.passwordHelp()
    }

}