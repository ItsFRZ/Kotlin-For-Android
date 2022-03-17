package day9.project.service

import day9.project.handler.restaurantop.PersistOperations
import day9.project.model.items.Restaurant

private val persistOperations = PersistOperations()



fun storeRestaurantsOf(username : String,restaurant: Restaurant){
    persistOperations.persistRestaurantDetails(username,restaurant)
}
