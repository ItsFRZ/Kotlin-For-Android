package day9.project.model.users

class Seller(username : String,emailId : String,password : String) : User() {

   var sellerID : Int = 0

   init{
       this.username = username
       this.emailId = emailId
       this.password = password
       this.isSeller = true
       this.isAdmin = false
       this.sellerID += 1
   }


}