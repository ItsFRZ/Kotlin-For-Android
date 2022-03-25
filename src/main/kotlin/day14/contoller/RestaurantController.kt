package day14.contoller

import day14.model.registration.UserRegistration

import day14.handler.getAllRestaurantInfoForUser
import day14.model.operation.Table

import day14.handler.removeRestaurantFromDb
import day14.handler.saveRestaurantInfo
//import day14.model.operation.Table

class RestaurantController(private var user : UserRegistration) {


    fun printAllRestaurantOfUser(){
        getAllRestaurantInfoForUser(user.contactId);
    }



    fun addRestaurantOfUser(contactId: String,rname : String,rtype : String,raddress : String,rTableCount : String,rTables : ArrayList<Table>){
        saveRestaurantInfo(contactId,rname,rtype,raddress,rTableCount,rTables);
    }

    fun removeRestaurant(rname : String){
        removeRestaurantFromDb(user.contactId,rname);
    }

}