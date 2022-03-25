package day14.handler

import day14.model.operation.Restaurant
import day14.model.operation.Table
import org.json.JSONArray
import org.json.JSONObject
import java.io.File


fun getAllRestaurantInfoForCustomer(username : String){

//    loadRestaurantData();
    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        gracefullyDisplayRestaurant(res)

    }

}

fun getPreferredRestaurantToCustomer(restaurantName : String,restaurantLocation : String){
//    loadRestaurantData();
    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        if(res.restaurantName.equals(restaurantName) && res.restaurantAddress.equals(restaurantLocation)) {
            gracefullyDisplayRestaurant(res)
        }

    }

}

fun getPreferredRestaurantToCustomerByLocation(username : String,seats : String,address : String) : Boolean{

    var availabilityFlag : Boolean = false

//    loadRestaurantData();
    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)

        if(res.restaurantAddress.contains(address)) {
            if(gracefullyDisplayRestaurantPreferrence(res,seats))
                availabilityFlag = true
        }

    }

    return true;
}

fun gracefullyDisplayRestaurantPreferrence(res: Restaurant, seats: String) : Boolean{
    var tableCount = 0;
    println("---------------------------***${res.restaurantName}***-----------------------------------")
    println("Restaurant Address :- ${res.restaurantAddress} , Restaurant Type :- ${res.restaurantType}")
    for(table in res.tables){
        if(table.seats.equals(seats) && table.isBooked.equals("false"))
        {
            println("Table id ${table.tableId} is available with seats ${table.seats}")
            tableCount += 1;
        }

    }

    if(tableCount > 0)
        println("$seats sitter table is Available")
    else
        println("$seats is not available")

    println("------------------------------------------~~~END~~~------------------------------------------")

    if(tableCount > 0)
        return true
    return false
}

fun bookATable(currentUser : String,restaurantName: String,seats: String,address: String,date : String) : Boolean{
    // loading all restaurants
//    loadRestaurantData()

    var isDone = false

    // filteration of restaurants
    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        if(res.restaurantAddress.contains(address) && res.restaurantName.equals(restaurantName)) {

            val fetchTableId = getAvaiableSeats(res,date,seats)
            val myBookedTable =  bookMyTable(res,fetchTableId,currentUser,date)
            res.tables.removeAt(fetchTableId.toInt()-1);
            res.tables.add(myBookedTable);
            val tablesBooked : Int = res.tablesBooked.toInt()
            res.tablesBooked = (tablesBooked+1).toString();
            isDone = true
            break;
        }
    }

    if(isDone){



        var jsonArray = JSONArray();
        if(RESTAURANT_DB.size > 0){
            for(i in 0 until RESTAURANT_DB.size){
                val jsonObject  = JSONObject(RESTAURANT_DB.get(i));

                jsonArray.put(jsonObject);
                println(jsonObject)
            }
        }

        val file = File(SELLER)
        if(file.exists())
            file.delete()

        writeData(SELLER,jsonArray.toString())
        return true;

    }


    return false;
}

fun bookMyTable(res: Restaurant, fetchTableId: String, currentUser: String, date: String): Table {
    val table = res.tables.get(fetchTableId.toInt()-1)
    table.isBooked = "true"
    table.bookedDate = date
    table.bookedBy = currentUser
    table.tableId =  table.tableId
    table.seats = table.seats
    return table;
}

fun getAvaiableSeats(res: Restaurant, date: String, seats: String): String {
    for(table in res.tables){
        if(table.seats.equals(seats) && table.bookedDate != date && table.isBooked.equals("false")){
            return table.tableId;
        }
    }
    return ""
}
