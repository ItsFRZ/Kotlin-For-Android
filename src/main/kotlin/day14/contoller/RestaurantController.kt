package day14.contoller

import day14.handler.getAllRestaurantInfoForUser

class RestaurantController(private var username : String) {


    fun printAllRestaurantOfUser(){
        getAllRestaurantInfoForUser(username);
    }

}