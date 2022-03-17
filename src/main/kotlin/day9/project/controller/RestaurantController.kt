package day9.project.controller

import day9.project.model.items.Restaurant
import day9.project.model.items.Tables
import day9.project.service.storeRestaurantsOf


fun displayAllRestaurantInfo(user : String){

}

fun addRestaurantInfo(ownername: String, restaurant: String, type: String, address: String, tableCount: Int, tables: ArrayList<Tables>){
    val restaurant = Restaurant(ownername,restaurant,type,address,tableCount,tables);
    storeRestaurantsOf(ownername,restaurant);
}