package day2

fun main(){

//    val name : String? = "John Grey"
//    println("Hello ${name ?: "John Doe"}")

////    Looping
//
    val names  = arrayOf("Rob","Ron","Ram","Ravi",12,12.3F,323233.3232323)
//    // Similar like enhanced for loop in java
//    for (i in names)
//        println(i)
//
//    // Similar like noraml for loop in java
//    for(i in names.indices){
//        print("${names[i]} ")
//    }


//    if("Faraz" !in names)
//        print("Not present")


//    loopRange()

//    val arr = arrayOf<String>("Crab","Crop","Cringe","Roast")
//    arrayReverseTraversal(arr)
//    arrayTraversal(arr)
//    extraUnusedLoops()


//    variable argument
    countAndPrint(1,2,3,4,5,6,)


}


fun loopRange(){

//    for(i in 1..5) // 1 2 3 4 5 // both points included
//         print("$i ")



//    skip
    for(i in 1..5 step 2)
        print("$i ")

    println()
//    backward iterate

    for(i in 10 downTo 1)
        print("$i ")


}

fun arrayReverseTraversal(arr : Array<String>){

    for(i in (arr.size-1) downTo 0)
        print("${arr[i]} ")
    println()

}
fun arrayTraversal(arr : Array<String>){

    for(i in 0..(arr.size-1))
        print("${arr[i]} ")
    println()
}

fun extraUnusedLoops(){


    //while loop
    var i = 1
    while(i <= 5)
        print("${i++} ")
    println()


    //dowhile loop

    var name : String? = null
    do{
        print("Faraz")
    }while(name != null)


}
fun countAndPrint(first : Int,second : Int,vararg number : Int){
    println("vararg size ${number.size}")
    println(first)
    println(second)
    for (i in 0..(number.size-1))
        print("${number[i]} ")
    println()
}


