package day9.project.model

class Customer(username : String,emailId : String,password : String) : User() {
    var customerID : Int = 0

    init{
        this.username = username
        this.emailId = emailId
        this.password = password
        this.isSeller = false
        this.isAdmin = false
        this.customerID += 1
    }
}