package day9.project.userinterface


var isCustomerLoggedIn = false
var isSellerLoggedIn = false
var isAdminLoggedIn = false

fun main() {

    if(isAdminLoggedIn || isSellerLoggedIn || isCustomerLoggedIn)
        operationUI();
    else
        authUI();



    main()


}



fun operationUI() {
    if(isCustomerLoggedIn){
        customerUI()
    }
    if(isSellerLoggedIn){
        sellerUI()
    }
    if(isAdminLoggedIn){
        adminUI()
    }
}



fun logoutUser(usermode : String){
    if(usermode.equals("admin") || usermode.equals("Admin"))
        isAdminLoggedIn = false

    if(usermode.equals("customer") || usermode.equals("Customer"))
        isCustomerLoggedIn = false

    if(usermode.equals("seller") || usermode.equals("Seller"))
        isSellerLoggedIn = false

    main()
}