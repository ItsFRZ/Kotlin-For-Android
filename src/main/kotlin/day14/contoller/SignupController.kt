package day14.contoller

import day14.handler.registerHandler


fun registerUser(username : String,contactType: String,password: String,email: String) : Boolean{

    return registerHandler(username,password,contactType,email)
}

