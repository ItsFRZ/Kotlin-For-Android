package day14.model.operation

data class Restaurant(
        var sellerName : String,
        var sellerEmail : String,
        var restaurantName : String,
        var restaurantAddress : String,
        var noOfTables : String,
        var tablesBooked : String,
        var tables : ArrayList<Table>
        )