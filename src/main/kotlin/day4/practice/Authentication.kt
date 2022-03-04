package day4.practice

import javax.print.attribute.standard.JobOriginatingUserName

open class Authentication : Locker(){

    private val emailPattern = Regex("^([\\w]{5,20})@([a-z]{3,12})\\.([a-z]{2,8})(\\.[a-z]{2,8})?\$")
    private val passwordPattern = Regex("^[0-9]{4,20}\$")


    fun validateCredentials (emailId : String,password : String) : Boolean{
        var eFlag : Boolean = false
        var pFlag : Boolean = false
        if(emailId.matches(emailPattern))
            eFlag = true
        if(password.matches(passwordPattern))
            pFlag = true

        return validateFlag(eFlag,pFlag);
    }

    private fun validateFlag(eFlag: Boolean, pFlag: Boolean): Boolean {
        if(eFlag && pFlag)
            return true
        else{
            if(!eFlag)
                emailHelp()
            else
                passwordHelp()
        }
        return false;
    }

    private fun passwordHelp() {
        println("Password should be in numeric form")
    }

    private fun emailHelp() {
        println("Email Id should be correct")
    }


//    Main Authentication Method
    fun authenticateCredentials(emailId: String,password: String) : Boolean{
        if(!validateCredentials(emailId,password))
            return false
        if(db.containsKey(emailId))
        {
            var passwordFromDB = db.get(emailId)
            if(passwordFromDB.equals(password))
                return true;
        }
        return false
    }
}