package day14.handler


import day14.model.operation.Restaurant
import day14.model.operation.Table
import day14.model.registration.UserRegistration
import org.json.JSONArray
import org.json.JSONObject
import java.io.File


// Database
var RESTAURANT_DB = ArrayList<Restaurant>();




// Path
const val SELLER = "$HOME/Seller.json"

fun getAllRestaurantInfoForUser(username : String){

    // Bug detected
    loadRestaurantData();
    for (i in 0 until RESTAURANT_DB.size){
        val res = RESTAURANT_DB[i]
        if(res.sellerName.equals(username)){
            gracefullyDisplayRestaurant(res)
        }
    }

}

fun gracefullyDisplayRestaurant(res: Restaurant) {
    println("-------------------------------------------~~~|${res.restaurantName}|~~~-------------------------------------------\n")
    println("Restaurant Type :- ${res.restaurantType} , Total Tables :- ${res.noOfTables} , Total Booked Tables :- ${res.tablesBooked}")
    println("Restaurant Location :- ${res.restaurantAddress}")
    for(table in res.tables){
        println("")
        println("----------------------------------------------------------****Table No :- ${table.tableId}****----------------------------------------------------------")
        println("Booked Status :- ${table.booked}, Total Seats :- ${table.seats}, Booked Date :- ${table.bookedDate}, Booked By :- ${table.bookedBy}")

    }
    println("----------------------------------------------------------------------~~~||~~~----------------------------------------------------------------------\n")

}



// Loading JSON Data from file into Data Structure

fun loadRestaurantData(){
    val file = File(SELLER);
    if(!file.exists())
        return;

    val allData = readData(SELLER);
    if(allData.length <= 0)
        return;

    RESTAURANT_DB = getMappedData(allData)

}

fun getMappedData(allData: String): ArrayList<Restaurant> {

    val jsonArray = JSONArray(allData);
    var data = ArrayList<Restaurant>();
    for(i in 0 until jsonArray.length()){

        val jsonObject = jsonArray.getJSONObject(i)
        val sellerName = jsonObject.getString("sellerName")
        val sellerEmail = jsonObject.getString("sellerEmail")
        val restaurantName = jsonObject.getString("restaurantName")
        val restaurantType = jsonObject.getString("restaurantType")
        val restaurantAddress = jsonObject.getString("restaurantAddress")
        val noOfTables = jsonObject.getString("noOfTables")
        val tablesBooked = jsonObject.getString("tablesBooked")
        val tables : ArrayList<Table> = getTablesData(jsonObject.getJSONArray("tables"))
       data.add(Restaurant(sellerName,sellerEmail,restaurantName,restaurantType,restaurantAddress,noOfTables,tablesBooked,tables))


    }

    return data;
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
fun saveRestaurantInfo(username : String,rname : String,rtype : String,raddress : String,rTableCount : String,rTables : ArrayList<Table>){

    val users = getUserList();
    var myUser  = users.get(username);
    if(myUser != null){

        val sellerName = myUser.get(1)
        val sellerEmail = myUser.get(4)
        val myRestaurant = Restaurant(
                sellerName,
                sellerEmail,
                rname,
                rtype,
                raddress,
                rTableCount,
                0.toString(),
                rTables
        )

        loadRestaurantData()
        RESTAURANT_DB.add(myRestaurant);


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


}

// Remove restaurant from DB
fun removeRestaurantFromDb(username : String,rname : String){

    val users = getUserList();
    var myUser  = users.get(username);
    if(myUser != null) {

        loadRestaurantData()
        for (i in 0 until RESTAURANT_DB.size){
            val user = RESTAURANT_DB.get(i);
            if(rname.equals(user.restaurantName.toString()) && username.equals(user.sellerName.toString())){

                RESTAURANT_DB.removeAt(i)
            }
        }
        var jsonArray = JSONArray();
        if(RESTAURANT_DB.size > 0){
            for(i in 0 until RESTAURANT_DB.size){
                val jsonObject  = JSONObject(RESTAURANT_DB.get(i));

                jsonArray.put(jsonObject);

            }
        }

        val file = File(SELLER)
        if(file.exists())
            file.delete()

        writeData(SELLER,jsonArray.toString())

    }

}
