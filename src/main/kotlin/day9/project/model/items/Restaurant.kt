package day9.project.model.items

import java.net.Inet4Address
import java.util.*
import kotlin.collections.ArrayList

enum class RestaurantType{
    FamilyStyle,
    CasualDining,
    FineDining
}

class Restaurant(owner : String,restaurantName : String,restaurantType: String,address: String,tableCount : Int,tables : ArrayList<Tables>){
    var owner : String = "";
    var restaurantName : String = ""
    var restaurantType : String = "";
    var address : String = "";
    var tableCount : Int = 0
    var tables : ArrayList<Tables> = ArrayList<Tables>();

    init{
        this.owner = owner;
        this.restaurantName = restaurantName
        this.restaurantType = restaurantType
        this.address = address;
        this.tableCount = tableCount
        this.tables = tables
    }

}