package day15

import java.text.SimpleDateFormat
import java.util.*


fun main() {

    val sdf = SimpleDateFormat("yyyy/MM/dd");
    val currentDate = sdf.format(Date())

    println(currentDate)
}