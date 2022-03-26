package day14.userinterface

import day14.contoller.AdminController
import day14.model.registration.UserRegistration


import kotlin.system.exitProcess

class AdminUserInterface(user: UserRegistration) {

    private val adminController : AdminController = AdminController(user)



    fun adminUI(){
        run();
    }


    private fun run(){
        println("Press 1 For Customers Info")
        println("Press 2 For Sellers Info")
        println("Press 3 For All Stats")
        println("Press 4 to Logout")
        println("Press 5 to Exit")
        try {
            val choice = readLine()?.toInt() ?: 0
            choiceMaker(choice);
        }catch (e : Exception){
            println("Please enter numeric value only")
            run()
        }


    }
    private fun choiceMaker(choice: Int) {
        when(choice){

            1->{
                showAllCustomerInfo()
            }
            2->{
                showAllSellerInfo();
            }
            3->{
                allStats();
            }
            4->{
                logoutAdmin()
            }
            5->{
                exitProcess(1)
            }
            else -> {
                run()
            }
        }
    }

    private fun logoutAdmin() {
        mainOne.logout();
    }

    private fun allStats() {
        adminController.showAllStats();
    }

    private fun showAllSellerInfo() {
        adminController.showAllSellerInfo();
    }

    private fun showAllCustomerInfo() {
       adminController.showAllCustomerInfo();
    }

}