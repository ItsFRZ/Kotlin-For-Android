package day9.project.model

class User(username : String,password : String,email : String) {

    var username : String = ""
    var password : String = ""
    var email : String = ""
    var isAdmin : Boolean = false
    var isRestaurantOwner : Boolean = false

    init{
        this.username = username
        this.password = password
        this.email = email
        this.isAdmin = false
        this.isRestaurantOwner = false
    }




}