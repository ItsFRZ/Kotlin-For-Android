package day14.contoller

import day14.handler.getBookingHistoryForAdmin
import day14.handler.getBookingHistoryForSeller
import day14.handler.storeSnapshot
import day14.model.operation.Restaurant
import day14.model.registration.UserMode
import day14.model.registration.UserRegistration

class BookingController(var user : UserRegistration) {


    fun saveAsBookingHistory(res : Restaurant,date : String){
        storeSnapshot(user,res,date)
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