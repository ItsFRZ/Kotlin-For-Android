package day14.model.operation


data class Booking(
        var username : String,
        var userId : String,
        var restaurantName : String,
        var sellerId : String,
        var bookedDate : String,
        )


data class Cancellation(
    var username : String,
    var userId : String,
    var restaurantName : String,
    var sellerId : String,
    var cancelledDate : String,
    )