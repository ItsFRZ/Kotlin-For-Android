package day14.model.registration

enum class UserMode{
    Admin,Seller,Customer
}

interface User {
    var uid : String
    var username : String
    var usermode : String
    var email : String
    var password : String
}