package day9.project.model.users

class Admin(username : String,emailId : String,password : String) : User() {

    var adminID : Int = 0

    init{
        this.username = username
        this.emailId = emailId
        this.password = password
        this.isSeller = false
        this.isAdmin = true
        this.adminID += 1
    }


}