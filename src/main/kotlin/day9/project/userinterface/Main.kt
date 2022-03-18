package day9.project.userinterface


var isCustomerLoggedIn = false
var isSellerLoggedIn = false
var isAdminLoggedIn = false

fun main() {

    if(isAdminLoggedIn || isSellerLoggedIn || isCustomerLoggedIn)
        operationUI();
    else
    {
        authUI();
        operationUI()
    }

    if(continueOperations())
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

    }
    if(isSellerLoggedIn){
        sellerUI()
    }
    if(isAdminLoggedIn){
        adminUI()
    }
}

