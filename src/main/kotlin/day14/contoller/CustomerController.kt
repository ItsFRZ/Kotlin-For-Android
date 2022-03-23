package day14.contoller

import day14.handler.getAllRestaurantInfoForCustomer
import day14.handler.getPreferredRestaurantToCustomer

class CustomerController(private var username : String) {
    fun displayAllRestaurantInfoToCustomer(){
        getAllRestaurantInfoForCustomer(username);
    }

    fun searchRestaurant(restaurantName : String,restaurantLocation : String){
        getPreferredRestaurantToCustomer(restaurantName,restaurantLocation)
    }

}

