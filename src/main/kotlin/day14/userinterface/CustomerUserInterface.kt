package day14.userinterface

import day14.contoller.CustomerController
import day14.model.registration.User
import kotlin.system.exitProcess


class CustomerUserInterface (user: User){

    fun customerUI() {
    println("Customer UI")
    //        run()
    }


    private fun run(){
        println("Press 1 to List Restaurant")
        println("Press 2 to Search Restaurant")
        println("Press 3 to Book a Table")
        println("Press 4 to Logout")
        println("Press 5 to Exit")
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
//            listAllRestaurantInfoForUser();
            }
            2->{
//            searchRestaurant();
            }
            3->{
//            bookATable();
            }
            4->{
//            logoutUser(currentUser);
            }
            5->{
                exitProcess(1);
            }
            else -> {
                run()
            }
        }
    }

//fun bookATable() {
//    println("Please enter your preferences followed by no of seats and location")
//    try {
//        println("How many seats in a table you want ?")
//        val seats = readLine()?.toInt() ?: 0
//
//        println("Enter city or address of preferred location which is good for you ?")
//        val address : String = readLine().toString();
//        val ispreferredRestaurant :Boolean = CustomerController(currentUser).fetchedPreferredTable(seats.toString(),address);
//        if(ispreferredRestaurant){
//            println("Please enter the name of restaurant you want to book from the given list")
//            val rname = readLine().toString()
//            println("Please enter the date (YYYY/MM/DD) example(2022/12/23)")
//            val date = readLine().toString();
//
//            val isBooked = CustomerController(currentUser).bookRestaurantTableForUser(rname,seats.toString(),address,date);
//            if(isBooked){
//                println("$currentUser your booking is done")
//            }else{
//                println("Something went wrong :(")
//                println("Either someone already booked your desired restaurant or internal problem's occured")
//            }
//        }else {
//            println("Either you not entered your preferences OR Table is not available")
//        }
//
//
//    }catch (e : Exception){
//        println("Please enter numeric values only")
//        bookATable()
//    }
//}
//
//fun searchRestaurant() {
//    println("Enter restaurant name ?")
//    var restaurantName : String = readLine().toString()
//    println("Enter restaurant address ?")
//    var restaurantLocation : String = readLine().toString()
//
//    CustomerController(currentUser).searchRestaurant(restaurantName,restaurantLocation)
//}
//
//
//fun logoutCustomer() {
//    logoutUser("User")
//}
//
//
//fun listAllRestaurantInfoForUser() {
//    CustomerController(currentUser).displayAllRestaurantInfoToCustomer();
//}



    private fun continueRun(){
        println("Do you want to continue ? (Y/y)")
        val ans = readLine().toString()
//        if(continueCheck(ans))
//            run()
        return
    }
}

