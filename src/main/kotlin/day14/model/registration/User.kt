package day14.model.registration

enum class UserMode{
    Admin,Seller,Customer
}

interface User {
    var contactId : String
    var username : String
    var contactType : String
    var email : String
    var password : String
}