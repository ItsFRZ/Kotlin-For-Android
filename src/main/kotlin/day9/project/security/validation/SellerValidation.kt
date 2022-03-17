package day9.project.security.validation

import day9.project.model.users.Seller

class SellerValidation : Validation(){



    fun validateRegisteredSeller(username : String,password : String) : Boolean{
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

    fun validateRestaurant(seller : Seller) : Boolean{
        var emailFlag = false
        var passwordFlag = false
        var usernameFlag = false

        if(validateEmail(seller.emailId))
            emailFlag = true
        else
            emailHelp()

        if(validateUsername(seller.username))
            usernameFlag = true
        else
            usernameHelp()

        if(validatePassword(seller.password))
            passwordFlag = true
        else
            passwordHelp()
       return (emailFlag&&passwordFlag&&usernameFlag)
    }



}