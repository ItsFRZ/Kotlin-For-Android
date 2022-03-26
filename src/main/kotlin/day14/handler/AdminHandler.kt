package day14.handler

import day14.model.registration.UserRegistration


fun showAllSellerInfoToAdmin(user : UserRegistration){

    println("--------------------------------------****${user.username}****--------------------------------------\n")
    for(myUser in USER_DB){
        if (myUser.get("contactType").equals("Seller"))
            printInformationGracefully(myUser)
    }

    println("\n------------------------------------|END|------------------------------------")


}

fun showAllCustomerInfoToAdmin(user : UserRegistration){

    println("--------------------------------------****${user.username}****--------------------------------------\n")
    for(myUser in USER_DB){
        if (myUser.get("contactType").equals("Customer"))
            printInformationGracefully(myUser)
    }

    println("\n------------------------------------|END|------------------------------------")


}

fun printInformationGracefully(user : HashMap<String,String>){
    println("Username :- ${user.get("username")} , EmailId :- ${user.get("email")}")
}


fun showAllInfoStatistically(user : UserRegistration) {

    val totalUsers : Int = USER_DB.size
    val totalCustomers : Int = getTotalCustomers()
    val totalSellers : Int = getTotalSellers()
    val totalRestaurant : Int = getTotalRestaurant()
    val totalBookingDone : Int = getTotalBookingDone();
    val totalBookingCancel : Int = getTotalBookingCancelled();

    println("---------------------------------------------****${user.username}****---------------------------------------------\n")
    println("Total Users            :-           ${totalUsers}")
    println("Total Customers        :-           ${totalCustomers}")
    println("Total Sellers          :-           ${totalSellers}")
    println("Total Restaurant       :-           ${totalRestaurant}")
    println("Total Booking's Done   :-           ${totalBookingDone}")
    println("Total Booking's Cancel :-           ${totalBookingCancel}")
    println("\n---------------------------------------------****|END|****---------------------------------------------\n")



}

fun getTotalRestaurant(): Int {
    LoadRestaurantData();
    return RESTAURANT_DB.size
}

fun getTotalBookingCancelled(): Int {
    LoadBookingHistory();
    var totalBookingCancel : Int = 0;
    for (booking in BOOKING_DB){
        if (!booking.bookedDate.equals("false") && !booking.cancelledDate.equals("false"))
            totalBookingCancel += 1
    }

    return totalBookingCancel;
}

fun getTotalBookingDone(): Int {
    LoadBookingHistory();
    var totalBookings : Int = 0;
    for (booking in BOOKING_DB){
        if (!booking.bookedDate.equals("false") && booking.cancelledDate.equals("false"))
            totalBookings += 1
    }

    return totalBookings;
}

fun getTotalSellers(): Int {
    var totalSellers = 0
    for(myUser in USER_DB){
        if (myUser.get("contactType").equals("Seller"))
            totalSellers += 1
    }
    return totalSellers
}

fun getTotalCustomers(): Int {
    var totalCustomer = 0
    for(myUser in USER_DB){
        if (myUser.get("contactType").equals("Customer"))
           totalCustomer += 1
    }
    return totalCustomer
}
