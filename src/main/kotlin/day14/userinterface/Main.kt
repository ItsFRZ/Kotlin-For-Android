package day14.userinterface



import day14.model.registration.UserMode
import day14.model.registration.UserRegistration



var mainOne = Main();



fun main(){
    mainOne.run();
}

class Main(){


    private val authentication= Authentication();
    private val user : UserRegistration = UserRegistration("","","","","");

    fun logout(){
        authentication.logout()
    }

    
    
    fun run(){

        if(authentication.isLoggedIn()){
            setUser(authentication.getLoggedUser())
            operationUI(user)
        }else{
            authentication.authUI()
        }

        run()

    }

    private fun setUser(myUser: UserRegistration) {
        val(contactId,username,contactType,password,email) = myUser
        this.user.apply {
            this.contactId = contactId
            this.username = username
            this.contactType = contactType
            this.password = password
            this.email = email
        }
    }


    private fun operationUI(user : UserRegistration) {
        val currentUserMode = user.contactType;
        if(currentUserMode.equals(UserMode.Customer.name)){
            CustomerUserInterface(user).customerUI()
        }
        if(currentUserMode.equals(UserMode.Seller.name)){
            SellerUserInterface(user).sellerUI()
        }
        if(currentUserMode.equals(UserMode.Admin.name)){
            AdminUserInterface(user).adminUI()
        }
    }




}
