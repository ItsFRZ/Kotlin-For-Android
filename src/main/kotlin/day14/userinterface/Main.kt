package day14.userinterface

import day14.model.registration.UserMode

fun main(){
    run();
}

private fun run(){
    if (currentUser.isEmpty())
        authUI()
    operationUI()

}


fun operationUI() {
    val currentUserMode = getUserMode(currentUser);
    if(currentUserMode.equals(UserMode.Customer.name)){
        customerUI()
    }
    if(currentUserMode.equals(UserMode.Seller.name)){
        sellerUI()
    }
    if(currentUserMode.equals(UserMode.Admin.name)){
//        adminUI()
        println("Admin UI")

    }
}



fun logoutUser(usermode : String){

}