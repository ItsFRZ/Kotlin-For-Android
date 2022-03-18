package day9.project.handler.restaurantop

import day9.project.model.items.*
import java.io.*

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

    fun removeRestaurantOf(username : String,restaurantName : String){
        val path = "$ADDRESS/$username.txt";
        val file = File(path);
        if (!file.exists())
        {
            println("Restaurant $restaurantName is not exist in database")
            return
        }

        var data = removeRestaurantAndGenerateData(restaurantName,path)
        deleteFileOf(path);
        writeData(path,data)
        println("$username your $restaurantName was removed from database")

    }


    private fun writeData(filePath : String,fileData : String){

        var file = File(filePath)
        if (!file.exists())
            file.createNewFile()
        try{
            val bwriter : BufferedWriter = BufferedWriter(FileWriter(filePath,true));
            bwriter.write(fileData)
            bwriter.close()

        }catch (e : Exception){
            println(e)
        }
    }


    private fun deleteFileOf(path: String) {
        val file = File(path);
        if(!file.exists())
            return

        file.delete()
    }

    private fun removeRestaurantAndGenerateData(restaurantName: String, path: String): String {
        var result : String = ""
        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                if(!line.toString().contains(restaurantName))
                    result += line+"\n"
            }
            reader.close()
        }catch (e : Exception){
            println(e)
        }
        return result
    }


    fun readData(path : String) {
        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                println(line)
            }
            reader.close()
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