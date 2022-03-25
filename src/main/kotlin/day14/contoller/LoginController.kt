package day14.contoller

import day14.handler.loginHandler
import day14.model.registration.UserRegistration


fun loginUserCheck(username:String, password : String) : UserRegistration{
    return loginHandler(username,password);
}



