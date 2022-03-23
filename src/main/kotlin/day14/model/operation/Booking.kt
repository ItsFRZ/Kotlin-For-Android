package day14.model.operation

import java.util.*

data class Booking(
        var username : String,
        var emailId : String,
        var restaurantName : String,
        var restaurantAddress : String,
        var tableSize : String,
        var bookingDate : Date,
        var isBooked : String,
        ) {
}