package day14.contoller

import day14.handler.getBookingHistoryForAdmin
import day14.handler.getBookingHistoryForSeller
import day14.handler.storeSnapshot
import day14.handler.updateSnapshot
import day14.model.operation.Restaurant
import day14.model.registration.UserMode
import day14.model.registration.UserRegistration
import java.text.SimpleDateFormat
import java.util.*

class BookingController(var user : UserRegistration) {


    fun saveAsBookingHistory(res : Restaurant,date : String){
        storeSnapshot(user,res,date)
    }

    fun updateInBookingHistory(bookedBy : String,restaurantName : String,bookedDate : String) : Boolean{

        val sdf = SimpleDateFormat("yyyy/MM/dd");
        val cancellingDate = sdf.format(Date())

        return updateSnapshot(user,restaurantName,bookedBy,bookedDate,cancellingDate);
    }

    fun getBookingHistory(){
        if(user.contactType.equals(UserMode.Seller.name)){
            getBookingHistoryForSeller(user.contactId)
        }
        if(user.contactType.equals(UserMode.Admin.name)){
            getBookingHistoryForAdmin(user.contactType)
        }
    }

}