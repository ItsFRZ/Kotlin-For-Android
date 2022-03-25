package day14.handler


import day14.model.operation.Restaurant
import day14.model.operation.Table

import org.json.JSONArray
import org.json.JSONObject
import java.io.File


fun getAllRestaurantInfoForUser(contactId : String){


    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB[i]
        if(res.contactId.equals(contactId))
            gracefullyDisplayRestaurant(res)

    }

}

fun gracefullyDisplayRestaurant(res: Restaurant) {
    println("-------------------------------------------------------~~~|****${res.restaurantName}****|~~~-------------------------------------------------------\n")
    println("Restaurant Type :- ${res.restaurantType} , Total Tables :- ${res.noOfTables} , Total Booked Tables :- ${res.tablesBooked}")
    println("Restaurant Location :- ${res.restaurantAddress}")
    for(table in res.tables){
        println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
        println("Table ${table.tableId} :- ")
        println("Booked Status  :- ${table.isBooked}, Total Seats ${table.tableId}:- ${table.seats}, Booked Date :- ${table.bookedDate}, Booked By :- ${table.bookedBy}")
        println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
    }
    println()
    println("----------------------------------------------------------------------~~~|END|~~~----------------------------------------------------------------------\n")

}



// Loading JSON Data from file into Data Structure

//fun loadRestaurantData(){
//    val file = File(SELLER);
//    if(!file.exists())
//        return;
//
//    val allData = readData(SELLER);
//    if(allData.length <= 0)
//        return;
//
//    RESTAURANT_DB = getMappedData(allData)
//
//}

//fun getMappedData(allData: String): ArrayList<Restaurant> {
//
//    val jsonArray = JSONArray(allData);
//    var data = ArrayList<Restaurant>();
//    for(i in 0 until jsonArray.length()){
//
//        val jsonObject = jsonArray.getJSONObject(i)
//        val sellerName = jsonObject.getString("sellerName")
//        val sellerEmail = jsonObject.getString("sellerEmail")
//        val restaurantName = jsonObject.getString("restaurantName")
//        val restaurantType = jsonObject.getString("restaurantType")
//        val restaurantAddress = jsonObject.getString("restaurantAddress")
//        val noOfTables = jsonObject.getString("noOfTables")
//        val tablesBooked = jsonObject.getString("tablesBooked")
//        val tables : ArrayList<Table> = getTablesData(jsonObject.getJSONArray("tables"))
//       data.add(Restaurant(sellerName,sellerEmail,restaurantName,restaurantType,restaurantAddress,noOfTables,tablesBooked,tables))
//
//
//    }
//
//    return data;
//}

fun getTablesData(jsonArray: JSONArray): ArrayList<Table> {

    val tables = ArrayList<Table>();

    for (i in 0 until jsonArray.length()){
        val jsonObject = jsonArray.getJSONObject(i);
        val tableId = jsonObject.getString("tableId");
        val isBooked = jsonObject.getString("booked");
        val seats = jsonObject.getString("seats");
        val bookedDate = jsonObject.getString("bookedDate");
        val bookedBy = jsonObject.getString("bookedBy");
        val table = Table(tableId,isBooked,seats, bookedDate, bookedBy);
        tables.add(table);
    }

    return tables;
}

// Persisting restaurant info to the user data
fun saveRestaurantInfo(contactId: String ,rname : String,rtype : String,raddress : String,rTableCount : String,rTables : ArrayList<Table>){

        RESTAURANT_DB.add(Restaurant(contactId,rname,rtype,raddress,rTableCount,"0",rTables));


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




}

// Remove restaurant from DB
//fun removeRestaurantFromDb(username : String,rname : String){
//    loadRestaurantData()
//    val users = getUserList();
//
//    var myUser  = users.get(username);
//
//
//    var isRemoved : Boolean = false
//
//    if(myUser != null) {
//
//        for (i in 0 until RESTAURANT_DB.size){
//            val restaurant = RESTAURANT_DB.get(i);
//            println(restaurant)
//            if(rname.equals(restaurant.restaurantName) && username.equals(restaurant.sellerName)){
//
//                RESTAURANT_DB.removeAt(i)
//                isRemoved = true;
//                break;
//            }
//        }
//
//    }
//
//
//    if(isRemoved){
//
//        var jsonArray = JSONArray();
//        if(RESTAURANT_DB.size > 0){
//            for(i in 0 until RESTAURANT_DB.size){
//                val jsonObject  = JSONObject(RESTAURANT_DB.get(i));
//
//                jsonArray.put(jsonObject);
//
//            }
//        }
//
//        val file = File(SELLER)
//        if(file.exists())
//            file.delete()
//
//        writeData(SELLER,jsonArray.toString())
//    }
//
//
//}
