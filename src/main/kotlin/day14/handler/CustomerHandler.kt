package day14.handler

import day14.contoller.BookingController
import day14.model.operation.Restaurant
import day14.model.operation.Table
import day14.model.registration.UserRegistration
import org.json.JSONArray
import org.json.JSONObject
import java.io.File


fun getAllRestaurantInfoForCustomer(contactId : String){

    LoadRestaurantData()

    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        gracefullyDisplayRestaurant(res)

    }

}

fun getPreferredRestaurantToCustomer(contactId: String,restaurantName : String,restaurantLocation : String){
    LoadRestaurantData()
    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        if(res.restaurantName.contains(restaurantName) && res.restaurantAddress.contains(restaurantLocation)) {
            gracefullyDisplayRestaurant(res)
        }

    }

}

fun getPreferredRestaurantToCustomerByLocation(seats : String,address : String) : Boolean{

    var availabilityFlag : Boolean = false

    LoadRestaurantData();

    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        if(res.restaurantAddress.contains(address)) {
            if(gracefullyDisplayRestaurantPreferrence(res, seats))
                availabilityFlag = true
        }

    }

    return availabilityFlag;
}


fun gracefullyDisplayRestaurantPreferrence(res: Restaurant, seats: String) : Boolean{
    var tableCount = 0;
    println("---------------------------***${res.restaurantName}***-----------------------------------")
    println("Restaurant Address :- ${res.restaurantAddress} , Restaurant Type :- ${res.restaurantType}")
    for(table in res.tables){
        if(table.isBooked.equals("false") && table.seats.equals(seats))
        {
            println("Table id ${table.tableId} is available with seats ${table.seats}")
            tableCount += 1;
        }

    }

    if(tableCount > 0)
        println("$seats sitter table is Available")
    else
    {
        println("$seats seat table is not available this restaurant")
    }

    println("------------------------------------------~~~END~~~------------------------------------------")

    if(tableCount > 0)
        return true
    return false
}

// Booking Issue

fun bookATable(user : UserRegistration,restaurantName: String,seats: String,address: String,date : String) : Boolean{
    // loading all restaurants
    LoadRestaurantData()

    var isDone = false

    for(restaurant in RESTAURANT_DB){

        if(restaurant.restaurantAddress.contains(address)){

            var fetchedTableId : String= getTableId(restaurant,seats)
            if(!fetchedTableId.isEmpty())
            {
                try{

                    isDone = true;


                    val oldTable: Table = getTableFromFetchedId(restaurant,fetchedTableId)
                    if(!oldTable.tableId.isEmpty()){

                        val table = modifyTable(oldTable,user,date)
                        restaurant.tables.removeAt(fetchedTableId.toInt()-1);
                        restaurant.tables.add(table);
                        restaurant.tablesBooked = setTablesBookedData(restaurant)
                        BookingController(user).saveAsBookingHistory(restaurant,date)
                        break;

                    }
                }catch (e : Exception){
                    println(e)
                }
            }


        }

    }


    if(isDone){

        var jsonArray = JSONArray();
        if(RESTAURANT_DB.size > 0){
            for(i in 0 until RESTAURANT_DB.size){
                val jsonObject  = JSONObject();
                val restaurant= RESTAURANT_DB.get(i)
                jsonObject.put("contactId",restaurant.contactId)
                jsonObject.put("restaurantName",restaurant.restaurantName)
                jsonObject.put("restaurantType",restaurant.restaurantType)
                jsonObject.put("restaurantAddress",restaurant.restaurantAddress)
                jsonObject.put("noOfTables",restaurant.noOfTables)
                jsonObject.put("tablesBooked",restaurant.tablesBooked)
                val tables : JSONArray = setTablesData(restaurant.tables)
                jsonObject.put("tables",tables)

                jsonArray.put(jsonObject);

            }

            val file = File(SELLER)
            if(file.exists())
                file.delete()

            writeData(SELLER,jsonArray.toString(4))

        }

        return true;

    }


    return false;
}

fun setTablesBookedData(restaurant: Restaurant): String {
    var tablesBooked = restaurant.tablesBooked.toInt()
    tablesBooked +=1
    return tablesBooked.toString();
}

fun getTableFromFetchedId(restaurant: Restaurant, fetchedTableId: String): Table {
    for (table in restaurant.tables){
        if(table.tableId.equals(fetchedTableId))
            return table
    }
    return Table("","","","","");
}


fun modifyTable(oldTable: Table, user: UserRegistration, date: String): Table {

    val table : Table = Table(
        oldTable.tableId,
        "true",
        oldTable.seats,
        date,
        user.username
    )
    return table
}



fun getTableId(restaurant: Restaurant, seats: String): String {
    for (table in restaurant.tables){
        if(table.seats.equals(seats))
            return table.tableId
    }
    return "";
}



