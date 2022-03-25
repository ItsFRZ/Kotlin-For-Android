package day14.contoller

import day14.handler.bookATable
import day14.handler.getAllRestaurantInfoForCustomer
import day14.handler.getPreferredRestaurantToCustomer
import day14.handler.getPreferredRestaurantToCustomerByLocation



class CustomerController(private var username : String) {
    fun displayAllRestaurantInfoToCustomer(){
        getAllRestaurantInfoForCustomer(username);
    }

    fun searchRestaurant(restaurantName : String,restaurantLocation : String){
        getPreferredRestaurantToCustomer(restaurantName,restaurantLocation)
    }

    fun fetchedPreferredTable(seats : String,address : String) : Boolean{
        return getPreferredRestaurantToCustomerByLocation(username,seats,address)
    }

    fun bookRestaurantTableForUser(restaurantName: String,seats: String,address: String,date : String) : Boolean{
        return bookATable(username,restaurantName,seats,address,date);
    }

}

