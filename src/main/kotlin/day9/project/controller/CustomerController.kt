package day9.project.controller

import day9.project.model.items.Restaurant
import day9.project.service.*


fun displayAllRestaurantInfoForUser(username : String){
    displayAllRestaurantInfoFromDB(username)
}


fun searchRestaurant(restaurantName : String,restaurantAddress : String){
    displaySelectedRestaurantInfoFromDB(restaurantName,restaurantAddress)
}

fun fetchedPreferredTable(username : String,seats : String,location : String) : Boolean{
    return fetchedPreferredTableService(username,seats,location);
}


fun bookRestaurantTableForUser(username : String,restaurantName: String,seats : String,location : String) {
    bookRestaurantTable(username,restaurantName,seats,location)
}