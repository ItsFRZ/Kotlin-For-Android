package day9.project.service

import day9.project.handler.admin.AdminOperations


private val adminOperations = AdminOperations()

fun displayAllCustomerInfoToAdmin(username : String){
    adminOperations.printAllCustomerDetail(username);
}

fun displayAllSellerInfoToAdmin(username : String){
    adminOperations.printAllSellerDetail(username);
}


fun removeDefaulterCustomerByAdmin(username : String,customerName:String,emailId : String){
    adminOperations.removeDefaulterCustomer(username,customerName,emailId)
}


fun removeDefaulterSellerByAdmin(username : String,sellerName:String,emailId : String){
    adminOperations.removeDefaulterSeller(username,sellerName,emailId)
}


