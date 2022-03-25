package day14.contoller

import day14.handler.LoadData


class UserSession(private val user : HashMap<String,String>) {
    fun isLoggedIn() : Boolean{
        return true;
    }
    fun getUser() : HashMap<String,String> = user

}