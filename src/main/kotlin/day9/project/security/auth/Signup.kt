package day9.project.security.auth

import day9.project.model.Admin
import day9.project.model.Customer
import day9.project.model.Seller
import day9.project.security.validation.AdminRegistrationValidation
import day9.project.security.validation.CustomerRegistrationValidation
import day9.project.security.validation.SellerRegistrationValidation
import day9.project.service.CustomerRegistrationService


class CustomerSignup() {

    fun register(customerRegistrationValidation: CustomerRegistrationValidation,customer: Customer) : Boolean {
        val validation = customerRegistrationValidation.validateCustomer(customer)
        if(validation)
            return true
        return false
    }


}

class AdminSignup(){
    fun register(adminValidation: AdminRegistrationValidation, admin: Admin): Boolean {
        val validation = adminValidation.validateAdmin(admin)
        if(validation)
            return true
        return false
    }
}

class SellerSignup(){
    fun register(sellerValidation: SellerRegistrationValidation, seller: Seller): Boolean {
        val validation = sellerValidation.validateRestaurant(seller)
        if(validation)
            return true
        return false
    }
}

