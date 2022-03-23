package day14.handler

import day14.model.operation.Restaurant







fun getAllRestaurantInfoForCustomer(username : String){

    loadRestaurantData();
    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        gracefullyDisplayRestaurant(res)

    }

}

fun getPreferredRestaurantToCustomer(restaurantName : String,restaurantLocation : String){
    loadRestaurantData();
    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        if(res.restaurantName.equals(restaurantName) && res.restaurantAddress.equals(restaurantLocation)) {
            gracefullyDisplayRestaurant(res)
        }

    }
}