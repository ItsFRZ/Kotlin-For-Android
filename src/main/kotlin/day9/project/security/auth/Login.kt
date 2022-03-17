package day9.project.security.auth

import day9.project.model.Customer
import day9.project.security.validation.AdminValidation
import day9.project.security.validation.CustomerValidation
import day9.project.security.validation.SellerValidation

class CustomerLogin(private var username : String,private var password : String) {

    fun login(customerLoginValidation: CustomerValidation) : Boolean {
        val validation = customerLoginValidation.validateRegisteredCustomer(username,password)
        if(validation)
            return true
        return false
    }

}

class AdminLogin(private var username : String,private var password : String) {

    fun login(adminLoginValidation: AdminValidation) : Boolean {
        val validation = adminLoginValidation.validateRegisteredAdmin(username,password)
        if(validation)
            return true
        return false
    }

}


class SellerLogin(private var username : String,private var password : String) {

    fun login(sellerLoginValidation: SellerValidation) : Boolean {
        val validation = sellerLoginValidation.validateRegisteredSeller(username,password)
        if(validation)
            return true
        return false
    }

}