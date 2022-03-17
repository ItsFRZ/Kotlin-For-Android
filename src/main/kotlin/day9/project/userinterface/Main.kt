package day9.project.userinterface


var isCustomerLoggedIn = false
var isSellerLoggedIn = false
var isAdminLoggedIn = false

fun main() {

    authUI();
    operationUI();

}

fun operationUI() {
    if(isCustomerLoggedIn){

    }
    if(isSellerLoggedIn){
        sellerUI()
    }
    if(isAdminLoggedIn){

    }
}

