package day9.project.userinterface

import day9.project.controller.*
import kotlin.system.exitProcess

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
            searchRestaurant();
        }
        3->{
            bookATable();
        }
        4->{

        }
        5->{
            logoutCustomer()
        }
        6->{
            exitProcess(1);
        }
        else -> {
            run()
        }
    }
}

fun bookATable() {
    println("Please enter your preferences followed by no of seats and location")

    try {
        println("How many seats in a table you want ?")
        val seats = readLine()?.toInt() ?: 0

        println("Enter city or address of preferred location which is good for you ?")
        val address : String = readLine().toString();
        val ispreferredRestaurant :Boolean = fetchedPreferredTable(activeUser,seats.toString(),address);
        if(ispreferredRestaurant){
            println("Please enter the name of restaurant you want to book from the given list")
            val rname = readLine().toString()
            bookRestaurantTableForUser(activeUser,rname,seats.toString(),address);
        }else {
            println("Either you not entered your preferences OR Table is not available")
        }


    }catch (e : Exception){
        println("Please enter numeric values only")
        bookATable()
    }

}

fun logoutCustomer() {
    logoutUser("customer")
}


fun listAllRestaurantInfoForUser() {
    displayAllRestaurantInfoForUser(activeUser)
}

fun searchRestaurant() {
    println("Enter restaurant name ?")
    var restaurantName : String = readLine().toString()
    println("Enter restaurant address ?")
    var restaurantLocation : String = readLine().toString()

    searchRestaurant(restaurantName,restaurantLocation)

}


private fun continueRun(){
    println("Do you want to continue ? (Y/y)")
    val ans = readLine().toString()
    if(continueCheck(ans))
        run()
    return
}