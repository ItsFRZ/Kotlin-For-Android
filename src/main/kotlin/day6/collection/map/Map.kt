package day6.collection.map


//fun main() {
//
//    // Immutable Map
//    val userInfo = mapOf<String,String>(
//            "ron@gmail.com" to "Ron",
//            "mat@gmail.com" to "Mathew");
//
//
//
//
//    val result : Boolean = userInfo.containsKey("ron@gmail.com")
//    println("Is Ron present $result")
//
//    for(key in userInfo.keys){
//        println("Username is ${userInfo.get(key)} and email id is $key")
//    }
//
//}

fun main(){

    // Mutable Map
    var userInfo = HashMap<String,String>()
    with(userInfo){
        put("Ron","Kolkata")
        put("Rick","Delhi")
        put("Shaun","Mumbai")
    }

    println(userInfo)
    userInfo.set("Ron","Pune")
    println(userInfo)
    var snapShot = userInfo.entries
    println(snapShot)
    val data = snapShot.iterator()
    while(data.hasNext()){
        val(k,v) = data.next()
        println("Key :-  $k & Value :- $v")
    }

}