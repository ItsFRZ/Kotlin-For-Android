

fun main(){


    val value : Int = 203;
    val revalue : Long = value.toLong()
    println("Value $revalue")

//    Type checking

    var name : Any = "Faraz"
    if(name is String)
        print("Hello $name")

}