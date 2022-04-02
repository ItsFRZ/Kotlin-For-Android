package day14.userinterface

import day14.contoller.CustomerController
import day14.contoller.RestaurantController
import day14.model.registration.User
import day14.model.registration.UserRegistration

import kotlin.system.exitProcess


class CustomerUserInterface (private var user: UserRegistration){


    private val customerController : CustomerController = CustomerController(user)



    fun customerUI() {
            run()
    }

    private fun run(){
        println("Press 1 to List Restaurant")
        println("Press 2 to Search Restaurant")
        println("Press 3 to Book a Table")
        println("Press 4 to See all bookings")
        println("Press 5 to Cancel Existing Booking")
        println("Press 6 to Logout")
        println("Press 7 to Exit")
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
                allBookingsInfo();
            }
            5->{
                cancelBooking();
            }
            6->{
                logoutCustomer();
            }
            7->{
                exitProcess(1);
            }

            else -> {
                run()
            }
        }
    }

    private fun cancelBooking() {
        println("Please enter your booking date NOTE :- Date should be in (YYYY/MM/DD) format")
        val date = readLine().toString()
        println("Please enter restaurant name")
        val restaurantName = readLine().toString();
        if(customerController.cancelBooking(date,restaurantName)){
           println("${user.username} you cancelled the booking of ${restaurantName}")
        }else {
            println("Internal Error OR Improper inputs failure")
        }
    }

    private fun allBookingsInfo() {
        customerController.customersAllBookings();
    }

    private fun logoutCustomer() {
        mainOne.logout();
    }

    fun bookATable() {
    println("Please enter your preferences followed by no of seats and location")
    try {
        println("How many seats in a table you want ?")
        val seats = readLine()?.toInt() ?: 0

        println("Enter city or address of preferred location which is good for you ?")
        val address : String = readLine().toString();
        val ispreferredRestaurant :Boolean = customerController.fetchedPreferredTable(seats.toString(),address);


        if(ispreferredRestaurant){
           bookTableFromList();

        }else {
            println("Either you not entered your preferences OR Table is not available")
        }


    }catch (e : Exception){
        println("Please enter numeric values only")
        bookATable()
    }
}

    private fun bookTableFromList() {

        try{

            println("Please enter the number from above given list (Input should be in Integer)")
            val restaurantNo = readLine().toString().toInt()
            if (restaurantNo < 0){
                println("Improper input")
                bookTableFromList()
                return;
            }

            println("Please enter Table Id to book your desired table (Input should be in Integer)")
            val tableId = readLine().toString().toInt()

            if (tableId < 0 && tableId > 20){
                println("Improper input")
                bookTableFromList()
                return;
            }



            println("Please enter the date (YYYY/MM/DD) example(2022/12/23)")
            val date = readLine().toString();

            val isBooked = customerController.bookRestaurantTableForUser(restaurantNo,tableId,date);
            if(isBooked){
                println("${user.username} your booking is done")
            }else{
                println("Something went wrong :(")
                println("Either someone already booked your desired restaurant or internal problem's occured")
            }

        }catch (e : Exception){
            println("Please enter proper inputs")
            bookTableFromList();
        }


    }

    fun searchRestaurant() {
        println("Enter restaurant name ?")
        var restaurantName : String = readLine().toString()
        println("Enter restaurant address ?")
        var restaurantLocation : String = readLine().toString()

        customerController.searchRestaurant(restaurantName,restaurantLocation)
    }

    fun listAllRestaurantInfoForUser() {
        customerController.displayAllRestaurantInfoToCustomer();
    }



    private fun continueRun(){
        println("Do you want to continue ? (Y/y)")
        val ans = readLine().toString()
        if(continueCheck(ans))
            run()
        return
    }

    private fun continueCheck(ans: String): Boolean {
        return ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.contains("Yes");
    }

}

