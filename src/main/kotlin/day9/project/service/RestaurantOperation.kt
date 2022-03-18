package day9.project.service

import day9.project.handler.restaurantop.*
import day9.project.model.items.Restaurant

private val persistOperations = PersistOperations()



fun storeRestaurantsOf(username : String,restaurant: Restaurant){
    persistOperations.persistRestaurantDetails(username,restaurant)
}

fun removeFromFile(username : String,restaurantName: String){
    persistOperations.removeRestaurantOf(username,restaurantName)
}

fun addNewTableInFile(username : String,restaurantName: String,seats : Int){
    persistOperations.addNewTableOf(username,restaurantName,seats)
}