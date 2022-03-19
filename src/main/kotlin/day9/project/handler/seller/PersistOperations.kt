package day9.project.handler.seller

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


    private fun getCleanData(restaurant: Restaurant): String {
        var finalData :  String = ""
        var tablesInfo : String = ""
        var idx = 0
        for (i in restaurant.tables){
            tablesInfo += "(${i.seatCounts}||${i.isBooked})_"
            idx+=1
        }
        val ownerName = restaurant.owner
        val restaurantName = restaurant.restaurantName
        val restaurantType = restaurant.restaurantType
        val restaurantAddress = restaurant.address
        val tableCounts = restaurant.tableCount

        println("${ownerName},${restaurantName},${restaurantType},${restaurantAddress},${tableCounts},${tablesInfo.substring(0,tablesInfo.length-1)}\n")
        return "${ownerName},${restaurantName},${restaurantType},${restaurantAddress},${tableCounts},${tablesInfo.substring(0,tablesInfo.length-1)}\n"
    }


    // Add New Table
    fun addNewTableOf(username : String,restaurantName : String ,seats : Int){
        val path = "$ADDRESS/$username.txt";
        val file = File(path);
        if (!file.exists())
        {
            println("Restaurant $restaurantName is not exist in database")
            return
        }

        var data : String = addTableAndGenerateData(restaurantName,path,seats)
        deleteFileOf(path);
        writeData(path,data)
        println("$username added a new $seats sitter table in $restaurantName")
    }

    private fun addTableAndGenerateData(restaurantName: String, path: String, seats: Int): String {
        var result : String  = ""
        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                if (line.contains(restaurantName)){
                    result += line+"_($seats||false)\n"
                }else{
                    result += line+"\n";
                }

            }
            reader.close()
        }catch (e : Exception){
            println(e)
        }

        return result
    }


    // Remove existing table from given restaurant
    fun removeTableOf(username : String,restaurantName : String ,table : Int){
        val path = "$ADDRESS/$username.txt";
        val file = File(path);
        if (!file.exists())
        {
            println("Restaurant $restaurantName is not exist in database")
            return
        }

        var data : String = removeTableAndGenerateData(restaurantName,path,table)
        deleteFileOf(path);
        writeData(path,data)
        println("$username removed $table table from $restaurantName")
    }

    private fun removeTableAndGenerateData(restaurantName: String, path: String, table: Int): String {
        var result : String  = ""
        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                if(line.contains(restaurantName)){
                    var targetLine = removeTableFromLine(line,table)
                }else{
                    result = line+"\n"
                }

            }
            reader.close()
        }catch (e : Exception){
            println(e)
        }

        return result
    }

    private fun removeTableFromLine(line: String, table: Int): String {
        var dataChunks = line.split(",")
        var halfData : String = getHalfData(dataChunks,0,dataChunks.size-2)
        var tables : String= dataChunks[5]
        var tableList = tables.split("_");
        if(tableList.size < table){
            println("You cannot remove $table because it has only ${tableList.size} no of table")
            return ""
        }
        var secondHalfData : String = getHalfData(tableList,0,table-1)
        return halfData+secondHalfData+"\n"

    }

    private fun getHalfData(dataChunks: List<String>, start: Int, end: Int): String {
        var data = ""
        for(i in start..end){
            data+=dataChunks.get(i)
        }
        return data
    }



    // Display All Restaurant For given user
    fun printRestaurantsDetail(username : String){
        val path = "$ADDRESS/$username.txt";
        val file = File(path);
        if (!file.exists())
        {
            println("Restaurant owner $username is not exist in database")
            return
        }

        printRestaurantsGracefully(username,path)

    }

     fun printRestaurantsGracefully(username: String, path: String) {
        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                val cleanInfo : String = getCleanInfo(line)
                println(cleanInfo)
            }
            reader.close()
        }catch (e : Exception){
            println(e)
        }
    }

    fun getCleanInfo(line: String): String {
        val dataChunks = line.split(",")
        val username =dataChunks.get(0)
        val restaurantName =dataChunks.get(1)
        val restaurantType =dataChunks.get(2)
        val restaurantAddress =dataChunks.get(3)
        val tableCount =dataChunks.get(4)
        val tablesInfo = getTablesInfo(dataChunks.get(5))
        var result = "--------------------------------------***${restaurantName}***--------------------------------------\n"
        result += "Restaurant Type :- $restaurantType\nRestaurant Location :-  $restaurantAddress\nTables in Restaurant :- $tableCount\n"
        result += "Table Status :\n$tablesInfo\n"
        result += "--------------------------------------***~END~***--------------------------------------\n\n"
        return result
    }

    private fun getTablesInfo(tables: String): String {
        val dataChunks = tables.split("_")
        var data : String = ""
        var idx : Int = 1
        for (part in dataChunks){
            var table = part.substring(1,part.length-1);
            var tableInfo = table.split("||")
            data += "Table $idx contains ${tableInfo.get(0)} seats and its status is ${isBooked(tableInfo.get(1))}\n"
            idx +=1

        }
        return data;
    }

    private fun isBooked(status: String): String {
        if(status.equals("true") || status.equals("True"))
            return "booked"
        return "not booked"
    }




    // Read Template

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




}