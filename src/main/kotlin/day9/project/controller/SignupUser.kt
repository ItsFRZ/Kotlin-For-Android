package day9.project.controller

import day9.project.model.users.Admin
import day9.project.model.users.Customer
import day9.project.model.users.Seller
import day9.project.security.auth.AdminSignup
import day9.project.security.auth.CustomerSignup
import day9.project.security.auth.SellerSignup
import day9.project.security.validation.AdminValidation
import day9.project.security.validation.CustomerValidation
import day9.project.security.validation.SellerValidation
import day9.project.service.AdminRegistrationService
import day9.project.service.CustomerRegistrationService
import day9.project.service.SellerRegistrationService


class PersistRegisteredUser(){

    fun saveCustomer(customerSignup: CustomerSignup, customerRegistrationValidation: CustomerValidation, customer: Customer){
        if(customerSignup.register(customerRegistrationValidation,customer)){
            CustomerRegistrationService().saveDataToFile(customer);
        }
    }

    fun saveAdmin(adminSignup: AdminSignup, adminRegistrationValidation: AdminValidation, admin: Admin){
        if(adminSignup.register(adminRegistrationValidation,admin)){
            AdminRegistrationService().saveDataToFile(admin);
        }
    }

    fun saveSeller(sellerSignup: SellerSignup, sellerRegistrationValidation: SellerValidation, seller: Seller){
        if(sellerSignup.register(sellerRegistrationValidation,seller)){
            SellerRegistrationService().saveDataToFile(seller);
        }
    }




}