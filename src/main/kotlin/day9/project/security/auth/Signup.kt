package day9.project.security.auth

import day9.project.model.Admin
import day9.project.model.Customer
import day9.project.model.Seller
import day9.project.security.validation.AdminValidation
import day9.project.security.validation.CustomerValidation
import day9.project.security.validation.SellerValidation


class CustomerSignup() {

    fun register(customerRegistrationValidation: CustomerValidation, customer: Customer) : Boolean {
        val validation = customerRegistrationValidation.validateCustomer(customer)
        if(validation)
            return true
        return false
    }


}

class AdminSignup(){
    fun register(adminValidation: AdminValidation, admin: Admin): Boolean {
        val validation = adminValidation.validateAdmin(admin)
        if(validation)
            return true
        return false
    }
}

class SellerSignup(){
    fun register(sellerValidation: SellerValidation, seller: Seller): Boolean {
        val validation = sellerValidation.validateRestaurant(seller)
        if(validation)
            return true
        return false
    }
}



