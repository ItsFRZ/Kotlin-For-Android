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

fun continueOperations(): Boolean {
    println("Do you want to continue to perform operation(Y/N)")
    val ans = readLine().toString().trim()
    if(ans.equals("y") || ans.equals("Y") || ans.equals("yes") || ans.equals("Yes"))
        return true
    return false
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