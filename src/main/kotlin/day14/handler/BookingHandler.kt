package day14.handler

import day14.model.operation.Booking
import day14.model.operation.Restaurant
import day14.model.registration.UserRegistration

import org.json.JSONArray
import org.json.JSONObject
import java.io.File


fun getBookingHistoryForSeller(contactId : String){
    LoadBookingHistory();

    var bookingStats : Int = 0
    var cacellationStats : Int = 0


    println("---------------------------------------------------*****BOOKING STATS FOR SELLER $contactId*****---------------------------------------------------\n")
    for (i in 0 until BOOKING_DB.size){
        val booking = BOOKING_DB[i]
       if(booking.sellerId.equals(contactId)){
           bookingStats += checkBookingStats(booking);
           cacellationStats += checkCancellationStats(booking);
           gracefullyDisplayBookings(booking)
       }
    }
    println("Total Bookings Done        :- ${bookingStats}")
    println("Total Bookings Cancelled   :- ${cacellationStats}")

    println("---------------------------------------------------*****END*****---------------------------------------------------\n")
}

fun getBookingHistoryForAdmin(contactType : String){
    LoadBookingHistory();

    var bookingStats : Int = 0
    var cacellationStats : Int = 0


    println("---------------------------------------------------*****BOOKING STATS FOR ADMIN*****---------------------------------------------------\n")
    for (i in 0 until BOOKING_DB.size){
        val booking = BOOKING_DB[i]
        bookingStats += checkBookingStats(booking);
        cacellationStats += checkCancellationStats(booking);
        gracefullyDisplayBookings(booking)
    }
    println("Total Bookings Done        :- ${bookingStats}")
    println("Total Bookings Cancelled   :- ${cacellationStats}")

    println("---------------------------------------------------*****END*****---------------------------------------------------\n")



}

fun checkCancellationStats(booking: Booking): Byte {
    if(!booking.bookedDate.equals("") && !booking.cancelledDate.equals(""))
        return 1
    else
        return 0
}

fun checkBookingStats(booking: Booking): Int {

    if(!booking.bookedDate.equals("") && booking.cancelledDate.equals(""))
        return 1
    else
        return 0

}

fun gracefullyDisplayBookings(booking: Booking) {
    println("Username :- ${booking.username}, Booked Restaurant Name :- ${booking.restaurantName}, Booking Date :- ${booking.bookedDate}")
}

fun storeSnapshot(user : UserRegistration, res : Restaurant,date : String){
    LoadBookingHistory();

    var isObjectSet : Boolean = false;
    val previousData : String = readData(BOOKING);


    var finalData : String = ""

    if(!previousData.isEmpty())
    {
        val jsonArray = JSONArray(previousData);
        val jsonObject = setDataInObject(user,res,date)
        finalData = jsonArray.put(jsonObject).toString(4);
        isObjectSet = true

    }else{
        val jsonObject = setDataInObject(user,res,date)
        val jsonArray = JSONArray().put(jsonObject)
        finalData = jsonArray.toString(4)
        isObjectSet = true
    }


    if(isObjectSet){

        var file = File(BOOKING)
        if (file.exists())
            file.delete()

        writeData(BOOKING,finalData)
    }






}

fun setDataInObject(user: UserRegistration, res: Restaurant, date: String): JSONObject {

    var jsonObject = JSONObject();
    try{
        jsonObject.put("username",user.username)
        jsonObject.put("userId",user.contactId)
        jsonObject.put("restaurantName",res.restaurantName)
        jsonObject.put("sellerId",res.contactId)
        jsonObject.put("bookedDate",date)
        jsonObject.put("cancelledDate","false")
    }catch (e : Exception) {
        println(e)
    }
    return jsonObject;
}

class LoadBookingHistory(){
    init{
        BOOKING_DB.clear()
        loadBookingHistoryList()
    }

    private fun loadBookingHistoryList() : ArrayList<Booking>{

        val rawData : String = readData(BOOKING);

        if (rawData.length <= 0)
            return BOOKING_DB;

        val jsonArray = JSONArray(rawData);
        for (i in 0 until jsonArray.length()){

            try{
                val jsonObject = jsonArray.getJSONObject(i);

                val sellerId = jsonObject.getString("sellerId")
                val restaurantName = jsonObject.getString("restaurantName")
                val bookedDate = jsonObject.getString("bookedDate")
                val userId = jsonObject.getString("userId")
                val cancelledDate = jsonObject.getString("cancelledDate")
                val username = jsonObject.getString("username")

                val myBooking = Booking(username, userId, restaurantName, sellerId, bookedDate, cancelledDate)

                BOOKING_DB.add(myBooking)
            }catch(e : Exception){
                println(e)
            }

        }
        return BOOKING_DB;
    }


}