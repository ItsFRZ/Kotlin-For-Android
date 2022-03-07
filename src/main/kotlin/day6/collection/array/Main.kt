package day6.collection.array

import java.util.*

fun main(args : Array<String>){

    var bikes = Array<String>(5){""}
    bikes[0] = "Pulsar"
    bikes.set(1,"Apache")

//    println(bikes.get(1))
//    inputBikes(bikes)

//    Forward
    printBikes(bikes)

//    Backward
    printReverse(bikes)
}

fun inputBikes(bikes: Array<String>) {

    val scn = Scanner(System.`in`);
    for (i in bikes.indices){
        println("Enter bike name for $i index")
        val name = scn.nextLine()
        bikes[i] = name
    }

}

fun printBikes(bikes : Array<String>){
    for(bike in bikes)
        println(bike)
}

fun printReverse(bikes : Array<String>){
    for(i in bikes.size-1 downTo 0)
        println(bikes.get(i))
}