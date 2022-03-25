package day14.contoller


import day14.authentication.Validation
import day14.handler.*
import day14.model.registration.User

import day14.model.registration.UserRegistration

class Signup(val username: String,val contactType: String,val password: String,val email: String){


    private var validation = Validation()



    fun isRegistered() : Boolean{
        return registerUser(username,contactType,password,email);
    }

    fun validateSignUpCredentials() : Boolean{
        return validation.validateSignUp(username,contactType,email,password);
    }

}