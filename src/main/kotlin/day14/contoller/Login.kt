package day14.contoller

import day14.authentication.Validation
import day14.model.registration.User
import day14.model.registration.UserRegistration


class Login(private var username:String,private var password : String) {

    private var validation = Validation()

    fun validateLoginCredentials() : Boolean{
        return validation.validateLogin(username,password);
    }

    fun login() : UserRegistration{
        return loginUserCheck(username,password)
    }




}
