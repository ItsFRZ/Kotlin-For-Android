import java.util.*

fun main(){


//    var discount : Number = 0
//    val price = 85
//    if(price > 50)
//        discount = 10
//    else
//        discount = 3
//
//    println("Price after discount is ${price-discount}")


//    val price : Int = 85
//    var discount = if(price > 50) 10 else 3
//
//    println("Price after discount is ${price-discount}")


//    whenCondition()




//    Example of when condition

    navigation()

}



fun whenCondition() : Unit{
    val rating : Boolean?  = false
    val result : Boolean = when(rating){
//        5 -> {
////            "High"
//            true
//        }
//        4,3 -> {
////            "Good"
//        }
//        2,1 -> {
////            "Poor"
//        }
//        else -> {
//
//        }
        true -> {
            false
        }
        false -> {
            true
        }
        null -> {
            false
        }

    }
    println("Rating by user is $result")
}


fun navigation(){

    val obj : Scanner = Scanner(System.`in`)
    println("Username ?")
    val username : String =   obj.nextLine()
    val authType : Int = authCheck(username)
    trigger(authType,username)


}

fun trigger(authType: Int,username : String) : Unit {

    when(authType){
        0 -> homePage(username)
        1 -> homePage(username)
        2 -> {
            homePage(username)
            feedPage(username)
        }
        3 -> {
            homePage(username)
            feedPage(username)
            adminPage(username)
        }
        4 ->{
            homePage(username)
            feedPage(username)
            adminPage(username)
            superAdminPage(username)
        }
    }

}


fun authCheck(username: String): Int {
    return when(username){
        "Ron","ron" -> 1
        "Robin","robin" -> 2
        "ash","Ash" -> 3
        "brandon","Brandon" -> 4
        else -> 0
    }
}

// for all user
fun homePage(username: String){
    println("Hey ${username} welcome to homepage")
}

// for authenticated user
fun feedPage(username: String){
    println("Hey ${username} welcome to your feed page")
}

// for authorized user
fun adminPage(username: String){
    println("Hey ${username} welcome to your Admin page")
}

// for authorized user
fun superAdminPage(username: String){
    println("Hey ${username} welcome to your Super Admin page")
}
