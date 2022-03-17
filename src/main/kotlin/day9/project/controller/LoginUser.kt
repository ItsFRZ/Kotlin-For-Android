package day9.project.controller

import day9.project.service.AdminLoginService
import day9.project.service.CustomerLoginService
import day9.project.service.SellerLoginService


class AuthenticateRegisteredUser(private var username : String,private var password : String){

    fun checkCustomerCredentials() : Boolean{
        val customerLoginService = CustomerLoginService()
        val allCustomers = customerLoginService.getCustomerCredentials()
        if(allCustomers.containsKey(username)){
            val fetchedPassword = allCustomers.get(username);
            if(fetchedPassword.equals(password))
                return true
        }

        return false
    }

}



class AuthenticateRegisteredAdmin(private var username : String,private var password : String){

    fun checkAdminCredentials() : Boolean{
        val adminLoginService = AdminLoginService()
        val allAdmins = adminLoginService.getAdminCredentials()
        if(allAdmins.containsKey(username)){
            val fetchedPassword = allAdmins.get(username);
            if(fetchedPassword.equals(password))
                return true
        }

        return false
    }

}


class AuthenticateRegisteredSeller(private var username : String,private var password : String){

    fun checkSellerCredentials() : Boolean{
        val sellerLoginService = SellerLoginService()
        val allSeller = sellerLoginService.getSellerCredentials()
        if(allSeller.containsKey(username)){
            val fetchedPassword = allSeller.get(username);
            if(fetchedPassword.equals(password))
                return true
        }
        return false
    }

}