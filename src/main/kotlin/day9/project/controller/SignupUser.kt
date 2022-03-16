package day9.project.controller

import day9.project.model.Admin
import day9.project.model.Customer
import day9.project.model.Seller
import day9.project.security.auth.AdminSignup
import day9.project.security.auth.CustomerSignup
import day9.project.security.auth.SellerSignup
import day9.project.security.validation.AdminRegistrationValidation
import day9.project.security.validation.CustomerRegistrationValidation
import day9.project.security.validation.SellerRegistrationValidation
import day9.project.service.AdminRegistrationService
import day9.project.service.CustomerRegistrationService
import day9.project.service.SellerRegistrationService


class PersistRegisteredUser(){

    fun saveCustomer(customerSignup: CustomerSignup, customerRegistrationValidation: CustomerRegistrationValidation, customer: Customer){
        if(customerSignup.register(customerRegistrationValidation,customer)){
            CustomerRegistrationService().saveDataToFile(customer);
        }
    }

    fun saveAdmin(adminSignup: AdminSignup, adminRegistrationValidation: AdminRegistrationValidation, admin: Admin){
        if(adminSignup.register(adminRegistrationValidation,admin)){
            AdminRegistrationService().saveDataToFile(admin);
        }
    }

    fun saveSeller(sellerSignup: SellerSignup, sellerRegistrationValidation: SellerRegistrationValidation, seller: Seller){
        if(sellerSignup.register(sellerRegistrationValidation,seller)){
            SellerRegistrationService().saveDataToFile(seller);
        }
    }




}