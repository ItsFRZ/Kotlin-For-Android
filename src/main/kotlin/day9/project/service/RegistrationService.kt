package day9.project.service

import day9.project.handler.registration.SaveUser
import day9.project.model.users.Admin
import day9.project.model.users.Customer
import day9.project.model.users.Seller

class CustomerRegistrationService{
    fun saveDataToFile(customer: Customer) {
        SaveUser().saveCustomer(customer)
    }
}

class AdminRegistrationService{
    fun saveDataToFile(admin: Admin) {
        SaveUser().saveAdmin(admin)
    }
}

class SellerRegistrationService{
    fun saveDataToFile(seller: Seller) {
        SaveUser().saveSeller(seller)
    }
}