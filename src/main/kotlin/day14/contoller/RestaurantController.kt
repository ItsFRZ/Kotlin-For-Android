package day14.contoller

import day14.handler.getAllRestaurantInfoForUser
import day14.handler.removeRestaurantFromDb
import day14.handler.saveRestaurantInfo
import day14.model.operation.Table

class RestaurantController(private var username : String) {


    fun printAllRestaurantOfUser(){
        getAllRestaurantInfoForUser(username);
    }

    fun addRestaurantOfUser(rname : String,rtype : String,raddress : String,rTableCount : String,rTables : ArrayList<Table>){
        saveRestaurantInfo(username,rname,rtype,raddress,rTableCount,rTables);
    }

    fun removeRestaurant(rname : String){
        removeRestaurantFromDb(username,rname);
    }

}