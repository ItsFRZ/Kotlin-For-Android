package day9.project.controller

import day9.project.model.items.*
import day9.project.service.*


fun displayAllRestaurantInfo(user : String){

}

fun addRestaurantInfo(ownername: String, restaurant: String, type: String, address: String, tableCount: Int, tables: ArrayList<Tables>){
    val restaurant = Restaurant(ownername,restaurant,type,address,tableCount,tables);
    storeRestaurantsOf(ownername,restaurant);
}

fun removeRestaurant(ownername: String,restaurantName : String){
    removeFromFile(ownername,restaurantName);
}

fun addTableRestaurant(ownername : String,restaurantName : String,seats:Int){
    addNewTableInFile(ownername,restaurantName,seats)
}