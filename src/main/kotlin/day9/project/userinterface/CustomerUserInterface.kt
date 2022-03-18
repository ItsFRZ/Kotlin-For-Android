package day9.project.userinterface

import day9.project.controller.*

private var activeUser = currentUser;

fun customerUI() {
    run()
}


private fun run(){
    println("Press 1 to List Restaurant")
    println("Press 2 to Search Restaurant")
    println("Press 3 to Book a Table")
    println("Press 4 to Cancel Booking")
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
            listAllRestaurantInfoForUser();
        }
        2->{

        }
        3->{

        }
        4->{

        }
        5->{

        }

        else -> {
            return
        }
    }
}

fun listAllRestaurantInfoForUser() {
    displayAllRestaurantInfoForUser(activeUser)
}


private fun continueRun(){
    println("Do you want to continue ? (Y/y)")
    val ans = readLine().toString()
    if(continueCheck(ans))
        run()
    return
}