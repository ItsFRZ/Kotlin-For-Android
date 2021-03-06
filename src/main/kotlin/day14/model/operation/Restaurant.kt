package day14.model.operation

enum class RestaurantType{
        FamilyStyle,
        CasualDining,
        FineDining
}

data class Restaurant(
        var contactId : String,
        var restaurantName : String,
        var restaurantType : String,
        var restaurantAddress : String,
        var noOfTables : String,
        var tablesBooked : String,
        var tables : ArrayList<Table>
        )