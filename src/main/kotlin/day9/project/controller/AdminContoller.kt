package day9.project.controller

import day9.project.service.*


fun displayAllCustomerInfo(username : String){
    displayAllCustomerInfoToAdmin(username)
}



fun displayAllSellerInfo(username : String){
    displayAllSellerInfoToAdmin(username)
}


fun removeDefaulterCustomer(username : String,customerName:String,emailId : String){
    removeDefaulterCustomerByAdmin(username,customerName,emailId)
}

