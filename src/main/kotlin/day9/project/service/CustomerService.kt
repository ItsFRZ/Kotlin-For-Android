package day9.project.service

import day9.project.handler.customer.*


private val custoomerOperations = CustomerOperation()

fun displayAllRestaurantInfoFromDB(username : String){
    custoomerOperations.displayAllRestaurantInfoFromDB(username);
}


fun displaySelectedRestaurantInfoFromDB(restaurantName : String,restaurantAddress : String){
    custoomerOperations.displaySelectedRestaurantInfoFromDB(restaurantName,restaurantAddress);
}


fun fetchedPreferredTableService(username : String,seats: String,location : String) : Boolean{
    return custoomerOperations.fetchedPreferredTable(username,seats,location);
}

fun bookRestaurantTable(username : String,restaurantName: String,seats : String,location : String){
    custoomerOperations.bookRestaurantTable(username,restaurantName,seats,location);
}