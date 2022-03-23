package day14.contoller

import day14.handler.getUserList


class UserSession(private val username : String) {
    fun userSession() : String{
        val users : HashMap<String,ArrayList<String>> = getUserList();
        return users.get(username)?.get(3) ?: "";
    }
}