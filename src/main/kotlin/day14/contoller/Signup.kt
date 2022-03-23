package day14.contoller


import day14.handler.generateUniqueId
import day14.handler.persistUser

import day14.model.registration.UserRegistration

class Signup(val username: String,val usermode: String,val password: String,val email: String){



    fun registerUser() : Boolean{
        val uid = generateUniqueId();
        val newUser = UserRegistration(uid,username,usermode,password,email);
        return persistUser(newUser)
    }

}