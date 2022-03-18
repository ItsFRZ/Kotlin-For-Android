package day9.project.service

import day9.project.handler.admin.AdminOperations


private val adminOperations : AdminOperations()

fun displayAllCustomerInfoToAdmin(username : String){
    adminOperations.printAllCustomerDetail(username);
}

