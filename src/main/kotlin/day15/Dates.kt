package day15

import java.text.SimpleDateFormat
import java.util.*


fun main() {

//    val sdf = SimpleDateFormat("yyyy/MM/dd");
//    val currentDate = sdf.format(Date())
//
//    println(currentDate)


//    for(i in 1..10){
//        val secret  : Int = getRandom(1,1000000)
//        println("${System.currentTimeMillis()} -- "+secret)
//    }



}

fun getRandom(min : Int,max : Int): Int{
    return (Math.random() * (max-min) + min).toInt()
}
