package day9.project.handler.restaurantop

import day9.project.model.items.Restaurant
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

private const val ADDRESS = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day9/project/database/seller";

fun generatePath(fileName : String) : String{
    return "$ADDRESS/$fileName.txt";
}

class PersistOperations {

    fun persistRestaurantDetails(fileName : String,restaurant: Restaurant){

        val path : String = generatePath(fileName)
        var file = File(path);
        if(!file.exists()){
            file.createNewFile();
        }

        try{
            var bwriter = BufferedWriter(FileWriter(path,true))
            val data : String = getCleanData(restaurant);
            bwriter.write(data)
            bwriter.close();
        }catch (e : Exception){
            println(e)
        }


    }

    private fun getCleanData(restaurant: Restaurant): String {
        var finalData :  String = ""
        var tablesInfo : String = ""
        var idx = 0
        for (i in restaurant.tables){
            tablesInfo += "(${idx}->${i.seatCounts}||${i.isBooked})"
            idx+=1
        }
        val ownerName = restaurant.owner
        val restaurantName = restaurant.restaurantName
        val restaurantType = restaurant.restaurantType
        val restaurantAddress = restaurant.address
        val tableCounts = restaurant.tableCount

        println("${ownerName},${restaurantName},${restaurantType},${restaurantAddress},${tableCounts},${tablesInfo}\n")
        return "${ownerName},${restaurantName},${restaurantType},${restaurantAddress},${tableCounts},${tablesInfo}\n"
    }


}