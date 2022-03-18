package day9.project.service

import day9.project.handler.customer.*


private val custoomerOperations = CustomerOperation()

fun displayAllRestaurantInfoFromDB(username : String){
    custoomerOperations.displayAllRestaurantInfoFromDB(username);
}

