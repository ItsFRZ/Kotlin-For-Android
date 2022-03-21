package day9.project.userinterface

import day9.project.controller.*
import kotlin.system.exitProcess


private var activeUser = currentUser;


fun adminUI(){
    activeUser = currentUser
    run();
}


private fun run(){
    println("Press 1 to For Customers Info")
    println("Press 2 to For Sellers Info")
    println("Press 3 Remove Customer")
    println("Press 4 Remove Seller")
    println("Press 5 to Logout")
    println("Press 6 to Exit")
    try {
        val choice = readLine()?.toInt() ?: 0
        choiceMaker(choice);
    }catch (e : Exception){
        println("Please enter numeric value only")
        continueRun()
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
            removeCustomer();
        }
        4->{
            removeSeller();
        }
        5->{
            logoutAdmin()
        }
        6->{
            exitProcess(1)
        }
        else -> {
            run()
        }
    }
}

fun removeSeller() {
    println("Enter Seller's Username")
    val username = readLine().toString()
    println("Enter Seller's EmailId")
    val password = readLine().toString()
    removeDefaulterSeller(activeUser,username,password)
}

fun removeCustomer() {
    println("Enter Customer's Username")
    val username = readLine().toString()
    println("Enter Customer's EmailId")
    val password = readLine().toString()
    removeDefaulterCustomer(activeUser,username,password)
}

fun showAllSellerInfo() {
    displayAllSellerInfo(activeUser)

}


fun logoutAdmin() {
    logoutUser("admin")
}

fun showAllCustomerInfo() {
    displayAllCustomerInfo(activeUser)
}

private fun continueRun(){
    println("Do you want to continue ? (Y/y)")
    val ans = readLine().toString()
    if(continueCheck(ans))
        run()
    return
}