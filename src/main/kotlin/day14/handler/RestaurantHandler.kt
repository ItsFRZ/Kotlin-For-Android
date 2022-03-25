package day14.handler


import day14.model.operation.Restaurant
import day14.model.operation.Table
import org.json.JSONArray
import org.json.JSONObject
import java.io.File


fun getAllRestaurantInfoForUser(contactId : String){


    LoadRestaurantData();
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
        println("Booked Status  :- ${table.isBooked}, Total Seats :- ${table.seats}, Booked Date :- ${table.bookedDate}, Booked By :- ${table.bookedBy}")
        println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
    }
    println()
    println("----------------------------------------------------------------------~~~|END|~~~----------------------------------------------------------------------\n")

}



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
                val res : Restaurant = RESTAURANT_DB.get(i)


                val jsonObject  = JSONObject();




                jsonObject.put("contactId",res.contactId);
                jsonObject.put("restaurantName",res.restaurantName)
                jsonObject.put("restaurantType",res.restaurantType)
                jsonObject.put("restaurantAddress",res.restaurantAddress)
                jsonObject.put("noOfTables",res.noOfTables)
                jsonObject.put("tablesBooked",res.tablesBooked)
                val tables : JSONArray = setTablesData(res.tables);
                jsonObject.put("tables",tables)





                jsonArray.put(jsonObject);
//                println(jsonObject)
            }
        }

        val file = File(SELLER)
        if(file.exists())
        {
            file.delete()
        }



        writeData(SELLER,jsonArray.toString(4))




}

fun setTablesData(tables: ArrayList<Table>): JSONArray{

    val jsonArray = JSONArray()
    for (table in tables){

        val jsonObject = JSONObject()
        jsonObject.put("tableId",table.tableId)
        jsonObject.put("isBooked",table.isBooked)
        jsonObject.put("seats",table.seats)
        jsonObject.put("bookedDate",table.bookedDate)
        jsonObject.put("bookedBy",table.bookedBy)

        jsonArray.put(jsonObject);

    }
    return jsonArray;
}

// Remove restaurant from DB
fun removeRestaurantFromDb(contactId: String,rname : String){
    LoadRestaurantData();

    var isRemoved : Boolean = false



    for (i in 0 until RESTAURANT_DB.size){
        val restaurant = RESTAURANT_DB.get(i);
//        println(restaurant)
        if(rname.equals(restaurant.restaurantName) && contactId.equals(restaurant.contactId)){
            RESTAURANT_DB.removeAt(i)
            isRemoved = true;
            break;
        }
    }



    if(isRemoved){

        var jsonArray = JSONArray();
        if(RESTAURANT_DB.size > 0){
            for(i in 0 until RESTAURANT_DB.size){
                val jsonObject  = JSONObject();
                val res = RESTAURANT_DB.get(i);


                jsonObject.put("contactId",res.contactId);
                jsonObject.put("restaurantName",res.restaurantName)
                jsonObject.put("restaurantType",res.restaurantType)
                jsonObject.put("restaurantAddress",res.restaurantAddress)
                jsonObject.put("noOfTables",res.noOfTables)
                jsonObject.put("tablesBooked",res.tablesBooked)
                val tables : JSONArray = setTablesData(res.tables);
                jsonObject.put("tables",tables)



                jsonArray.put(jsonObject);

            }
        }

        val file = File(SELLER)
        if(file.exists())
            file.delete()

        writeData(SELLER,jsonArray.toString(4))
    }


}

// Add table in existing restaurant
fun addNewTableInFile(contactId: String,restaurantName : String,seats : String){

    LoadRestaurantData();

    var isPresent : Boolean = false


    for (i in 0 until RESTAURANT_DB.size){
        val restaurant = RESTAURANT_DB.get(i);
//        println(restaurant)
        if(restaurantName.equals(restaurant.restaurantName) && contactId.equals(restaurant.contactId)){
            isPresent = true;

            val fTable = restaurant.tables
            val tableId = (fTable.size+1).toString()
            val isBooked = "false"
            val chairs : String = seats
            val bookedDate : String = "NA"
            val bookedBy : String = "NA"

            val myTable = Table(tableId,isBooked,chairs,bookedDate,bookedBy)
            RESTAURANT_DB.get(i).tables.add(myTable)
            RESTAURANT_DB.get(i).noOfTables = RESTAURANT_DB.get(i).tables.size.toString();
            break;
        }
    }

    if(isPresent){


        var jsonArray = JSONArray();
        if(RESTAURANT_DB.size > 0) {
            for (i in 0 until RESTAURANT_DB.size) {
                val jsonObject = JSONObject();
                val res = RESTAURANT_DB.get(i);


                jsonObject.put("contactId", res.contactId);
                jsonObject.put("restaurantName", res.restaurantName)
                jsonObject.put("restaurantType", res.restaurantType)
                jsonObject.put("restaurantAddress", res.restaurantAddress)
                jsonObject.put("noOfTables", res.noOfTables)
                jsonObject.put("tablesBooked", res.tablesBooked)
                val tables: JSONArray = setTablesData(res.tables);
                jsonObject.put("tables", tables)

                jsonArray.put(jsonObject);
            }
        }


        val file = File(SELLER)
        if(file.exists())
            file.delete()

        writeData(SELLER,jsonArray.toString(4))

    } else{
            println("$restaurantName is not present in database")
        }

}


// Print All Booking Stats

fun printAllBookingsForUser(contactId : String){
    getBookingHistoryForSeller(contactId);
}


