package day14.contoller

import day14.handler.getUserList

class Login(private var username:String,private var password : String) {

    fun login() : Boolean{
        val users : HashMap<String,ArrayList<String>> = getUserList();
        val rusername : String = users.get(username)?.get(1) ?: "";
        val rpassword : String = users.get(username)?.get(2) ?: "";
        return username.equals(rusername) && password.equals(rpassword);
    }

}
