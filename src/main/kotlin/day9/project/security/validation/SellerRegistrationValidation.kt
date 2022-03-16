package day9.project.security.validation

import day9.project.model.Seller

class SellerRegistrationValidation : Validation(){

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