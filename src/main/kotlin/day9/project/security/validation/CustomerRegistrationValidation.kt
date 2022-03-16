package day9.project.security.validation

import day9.project.model.Customer

class CustomerRegistrationValidation : Validation(){

    fun validateCustomer(customer : Customer) : Boolean{
        var emailFlag = false
        var passwordFlag = false
        var usernameFlag = false
        if(validateEmail(customer.emailId))
            emailFlag = true
        else
            emailHelp()

        if(validateUsername(customer.username))
            usernameFlag = true
        else
            usernameHelp()

        if(validatePassword(customer.password))
            passwordFlag = true
        else
            passwordHelp()


        return (emailFlag&&passwordFlag&&usernameFlag)
    }

}