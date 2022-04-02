package day14.contoller

import day14.handler.*
import day14.model.registration.UserRegistration


class CustomerController(private var user : UserRegistration) {


    fun displayAllRestaurantInfoToCustomer(){
        getAllRestaurantInfoForCustomer(user.contactId);
    }


    fun searchRestaurant(restaurantName : String,restaurantLocation : String){
        getPreferredRestaurantToCustomer(user.contactId,restaurantName,restaurantLocation)
    }

    fun fetchedPreferredTable(seats : String,address : String) : Boolean{
        return getPreferredRestaurantToCustomerByLocation(seats,address)
    }

    fun bookRestaurantTableForUser(restaurantNo: Int,tableId: Int,date : String) : Boolean{
        return bookATable(user,restaurantNo,tableId,date);
    }


    fun customersAllBookings(){
        return customersBooking(user);
    }

    fun cancelBooking(date: String, restaurantName: String) : Boolean {
        return cancelBooking(user,date,restaurantName);
    }

}

