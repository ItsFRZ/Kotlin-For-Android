package day14.contoller


import day14.handler.showAllCustomerInfoToAdmin
import day14.handler.showAllInfoStatistically
import day14.handler.showAllSellerInfoToAdmin
import day14.model.registration.UserRegistration

class AdminController(private var user : UserRegistration){

    fun showAllCustomerInfo() {
        showAllCustomerInfoToAdmin(user)
    }

    fun showAllSellerInfo() {
        showAllSellerInfoToAdmin(user)
    }

    fun showAllStats() {
        showAllInfoStatistically(user);
    }

}