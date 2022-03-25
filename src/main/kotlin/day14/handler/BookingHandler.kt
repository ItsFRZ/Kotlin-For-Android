package day14.handler

import day14.model.operation.Booking

import org.json.JSONArray


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