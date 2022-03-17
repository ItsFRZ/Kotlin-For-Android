package day9.project.security.validation

import day9.project.model.users.Admin

class AdminValidation : Validation(){


    fun validateRegisteredAdmin(username : String,password : String) : Boolean{
        var usernameFlag = false
        var passwordFlag = false
        if(validateUsername(username))
            usernameFlag = true
        else
            usernameHelp()

        if(validatePassword(password))
            passwordFlag = true
        else
            passwordHelp()

        return (passwordFlag&&usernameFlag)


    }

    fun validateAdmin(admin : Admin) : Boolean{
        var emailFlag = false
        var passwordFlag = false
        var usernameFlag = false
        if(validateEmail(admin.emailId))
            emailFlag = true
        else
            emailHelp()

        if(validateUsername(admin.username))
            usernameFlag = true
        else
            usernameHelp()

        if(validatePassword(admin.password))
            passwordFlag = true
        else
            passwordHelp()

        return (emailFlag&&passwordFlag&&usernameFlag)
    }

}