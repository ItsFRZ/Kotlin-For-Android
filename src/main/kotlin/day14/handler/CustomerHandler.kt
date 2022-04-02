package day14.handler

import day14.contoller.BookingController
import day14.contoller.RestaurantController
import day14.model.operation.Booking
import day14.model.operation.Restaurant
import day14.model.operation.Table
import day14.model.registration.UserRegistration
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


val usersPreferredRestaurantList : ArrayList<Restaurant> = ArrayList<Restaurant>();

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

// Current Working
fun getPreferredRestaurantToCustomerByLocation(seats : String,address : String) : Boolean{

    var availabilityFlag : Boolean = false

    LoadRestaurantData();
    usersPreferredRestaurantList.clear();

    var chooseRestaurantIdx : Int = 0;

    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB.get(i)
        if(res.restaurantAddress.contains(address)) {

            if(gracefullyDisplayRestaurantPreferrence(res, seats,chooseRestaurantIdx)) {
                availabilityFlag = true

                usersPreferredRestaurantList.add(res);
                chooseRestaurantIdx += 1;
            }
        }

    }

    return availabilityFlag;
}

fun gracefullyDisplayRestaurantPreferrence(res: Restaurant, seats: String,chooseRestaurantIdx : Int) : Boolean{
    var tableCount = 0;

    var specificTableAvailability : Boolean = false

    println("\nPress ${chooseRestaurantIdx} to select---------------------------***${res.restaurantName}***-----------------------------------\n")
    println("Restaurant Address :- ${res.restaurantAddress}")
    println("Restaurant Type :- ${res.restaurantType}\n")
    var tableIdx = 1;
    for(table in res.tables){
        if(table.seats.equals(seats) && table.isBooked.equals("false"))
            specificTableAvailability = true;

        if(table.isBooked.equals("false") && table.seats >= seats)
        {
            println("Table id ${table.tableId} is available with seats ${table.seats}")
            tableCount += 1;
            tableIdx +=1;
        }

    }

    if(specificTableAvailability)
        println("$seats seater table is Available")
    else
    {
        println("$seats seater table is not available in this restaurant")
    }

    println("\n------------------------------------------~~~END~~~------------------------------------------\n")

    if(tableCount > 0)
        return true
    return false
}

fun bookATable(user : UserRegistration,restaurantNo: Int,tableId: Int,date : String) : Boolean{
    // loading all restaurants
    LoadRestaurantData()
    println(RESTAURANT_DB)

    // User Restaurant
    val userRestaurant : Restaurant = usersPreferredRestaurantList.get(restaurantNo)
    // User Table
    val updatedRestaurant : Restaurant = updateRestaurant(userRestaurant,tableId,user,date);

    var isDone = false
    // Remove Restaurant

    for(idx in 0 until RESTAURANT_DB.size){
        val restaurantName = updatedRestaurant.restaurantName;
        val restaurantAddress = updatedRestaurant.restaurantAddress;
        if (RESTAURANT_DB[idx].restaurantName.equals(restaurantName) && RESTAURANT_DB[idx].restaurantAddress.equals(restaurantAddress)){
            RESTAURANT_DB.set(idx,updatedRestaurant)

            isDone = true;
        }
        println(RESTAURANT_DB[idx])
    }

    println(RESTAURANT_DB)



//    modifyTable
//    removeTableFromRestaurant
//    setTablesBookedData




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

            BookingController(user).saveAsBookingHistory(updatedRestaurant,date)
            writeData(SELLER,jsonArray.toString(4))

        }

        return true;

    }


    return false;
}



//userRestaurant,tableId,user,date

fun updateRestaurant(userRestaurant: Restaurant, tableId: Int,user: UserRegistration,date: String): Restaurant {
    val contactId = userRestaurant.contactId;
    val restaurantName = userRestaurant.restaurantName;
    val restaurantType = userRestaurant.restaurantType
    val restaurantAddress = userRestaurant.restaurantAddress
    val noOfTable = userRestaurant.noOfTables
    val tablesBooked = (userRestaurant.tablesBooked.toInt()+1).toString()
    val tables : ArrayList<Table> = listMyTable(userRestaurant.tables,tableId,user,date);


    return Restaurant(contactId,restaurantName,restaurantType,restaurantAddress,noOfTable,tablesBooked,tables);
}


//userRestaurant.tables,tableId,user,date
fun listMyTable(tables: ArrayList<Table>, tableId: Int,user: UserRegistration,date: String): ArrayList<Table> {

    val myTables : ArrayList<Table> = ArrayList<Table>();

    for (table in tables){
        if(tableId.toString().equals(table.tableId)){
            table.isBooked = "true"
            table.bookedDate = date
            table.bookedBy = user.username
            myTables.add(table);
        }else{
            myTables.add(table);
        }

    }

    return myTables;
}

//fun removeTableFromRestaurant(restaurant: Restaurant, fetchedTableId: String) : Int{

//    var idx = 0
//    for (table in restaurant.tables){
//        if (table.tableId.equals(fetchedTableId))
//        {
//            restaurant.tables.removeAt(idx)
//            return idx;
//        }
//        idx+=1;
//    }
//    return idx;
//}

//fun modifyTable(fetchedTableId: String, oldTable: Table, user: UserRegistration, date: String): Table {
//
//    val table : Table = Table(
//        fetchedTableId,
//        "true",
//        oldTable.seats,
//        date,
//        user.username
//    )
//    return table;
//}

//fun setTablesBookedData(restaurant: Restaurant): String {
//    var tablesBooked = restaurant.tablesBooked.toInt()
//    tablesBooked +=1
//    return tablesBooked.toString();
//}

fun getTableFromFetchedId(restaurant: Restaurant, fetchedTableId: String): Table {
    for (table in restaurant.tables){
        if(table.tableId.equals(fetchedTableId))
            return table
    }
    return Table("","","","","");
}

fun getTableId(restaurant: Restaurant, seats: String): String {
    for (table in restaurant.tables){
        if(table.seats.equals(seats))
            return table.tableId
    }
    return "";
}

// Display All bookings of customer
fun customersBooking(user : UserRegistration){
    LoadBookingHistory();
    var totalBookings = 0;


    println("-------------------------------------------****${user.username}****-------------------------------------------\n")
    for (booking in BOOKING_DB){
        if(booking.userId.equals(user.contactId) && booking.cancelledDate.equals("false")){
            displayAllBookingsGracefully(booking)
            totalBookings += 1;
        }
    }

    if (totalBookings > 0){
        println("${user.username} you have $totalBookings bookings");
    }else{
        println("${user.username} you not have any bookings")
    }
    println("\n-------------------------------------------****END****-------------------------------------------")


}

fun displayAllBookingsGracefully(booking: Booking) {
    println("Restaurant Name :- ${booking.restaurantName}")
    println("Date of Visiting/Booking :- ${booking.bookedDate}\n")
}

fun cancelBooking(user : UserRegistration,date : String,restaurantName : String) : Boolean{

    var selledContactId = 0;
    var customerContactId = user.contactId
    var bookedBy = user.username;
    var bookedDate = date;
    var restaurantName = restaurantName;


    // Finding & Updating Data in Booking History
    val isUpdatedInBookingHistory : Boolean = updateBookingHistory(user,bookedBy,restaurantName,bookedDate);

    // Finding & Updating Data in Restaurant
    val isRestaurantTableClean : Boolean = updateBookedRestaurantTable(user,restaurantName,bookedDate);

    return isUpdatedInBookingHistory && isRestaurantTableClean;
}

fun updateBookedRestaurantTable(user: UserRegistration, restaurantName: String, bookedDate: String): Boolean {
    return RestaurantController(user).cancellBooking(user,restaurantName,bookedDate);
}

fun updateBookingHistory(user : UserRegistration,bookedBy: String, restaurantName: String, bookedDate: String): Boolean {
    return BookingController(user).updateInBookingHistory(bookedBy,restaurantName,bookedDate);
}
