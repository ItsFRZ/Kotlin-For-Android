package day9.project.controller

import day9.project.model.items.Restaurant
import day9.project.service.*


fun displayAllRestaurantInfoForUser(username : String){
    displayAllRestaurantInfoFromDB(username)
}


fun searchRestaurant(restaurantName : String,restaurantAddress : String){
    displaySelectedRestaurantInfoFromDB(restaurantName,restaurantAddress)
}

