
fun main(){


    var name : String? = null


    // How to tackle with null pointer exception
//    if(name!!.length > 0)
//        print("Hello $name")


        name = "Faraz Sheikh"
        print("Name length : ${name?.length ?: 0}")






}


