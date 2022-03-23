package day14.model.operation



class BookingHistory(var restaurantName : String,var tableId : String,var bookedBy : String)

data class Administration(
        var username : ArrayList<BookingHistory>
)