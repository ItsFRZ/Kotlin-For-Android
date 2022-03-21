package day9.project.handler.customer

import day10.filehandling.writeData
import day9.project.handler.seller.PersistOperations
import day9.project.handler.seller.generatePath
import java.io.*
import java.util.*

private const val ADDRESS = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day9/project/database";
private const val SELLERDIRECTORYPATH = "$ADDRESS/seller"

class CustomerOperation {



    // List all restaurant

    fun displayAllRestaurantInfoFromDB(username : String){

        var dir = File(SELLERDIRECTORYPATH)
        val listFilesPath = dir.listFiles();
        if (listFilesPath != null){
            for (path in listFilesPath){

                readCleanData(path.name,path.path)
            }
        }

    }

    private fun readCleanData(ownerName : String,path: String) {

        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                val cleanInfo : String = PersistOperations().getCleanInfo(line)
                println(cleanInfo)

            }
            reader.close()
        }catch (e : Exception){
            println(e)
        }

    }





    // List selected restaurant

    fun displaySelectedRestaurantInfoFromDB(restaurantName : String,restaurantAddress : String){
        iterateAllRestaurantInfoFromDB(restaurantName,restaurantAddress)
    }

    fun iterateAllRestaurantInfoFromDB(restaurantName : String,restaurantAddress : String){

        var dir = File(SELLERDIRECTORYPATH)
        val listFilesPath = dir.listFiles();
        if (listFilesPath != null){
            for (path in listFilesPath){
               searchDetailsOfRestaurantName(restaurantName,restaurantAddress, "$SELLERDIRECTORYPATH/${path.name}");
            }
        }

    }

    private fun searchDetailsOfRestaurantName(restaurantName: String, restaurantAddress: String, path: String) {

        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                if(checkIsPresent(restaurantName,restaurantAddress,line))
                {
                    val mySearchResult : String= PersistOperations().getCleanInfo(line);
                    println(mySearchResult)
                    return
                }
            }
            println("$restaurantName is not found in the database")
            reader.close()
        }catch (e : Exception){
            println(e)
        }


    }

    private fun checkIsPresent(restaurantName: String, restaurantAddress: String, line: String): Boolean {
        val dataChunk = line.split(",")
        val rName = dataChunk.get(1)
        val rStyle = dataChunk.get(2)
        val rAddress = dataChunk.get(3)
        val rTablesCount = dataChunk.get(3)
        val rTables = dataChunk.get(3);

        if(rName.contains(restaurantName) && rAddress.equals(restaurantAddress))
            return true
        return false
    }


    // Fetched Preffered Table
    fun fetchedPreferredTable(username: String, seats: String,location : String) : Boolean{
        return iterateDirectory(seats,location)
    }

    fun iterateDirectory(seats: String,location : String) : Boolean{

        var isFound : Boolean = false
        val dir = File(SELLERDIRECTORYPATH)
        val listFilesPath = dir.listFiles()
        if (listFilesPath != null){

            for (path in listFilesPath){
                if(listOutPreferences(path.path,seats,location)){
                    isFound = true
                }
            }

        }

        return isFound;
    }

    private fun listOutPreferences(filePath: String, seats: String, location: String): Boolean {



        val reader = BufferedReader(FileReader(filePath));
        val iterator = reader.lineSequence().iterator()
        var flag : Boolean = false
        while (iterator.hasNext()){
            val line = iterator.next()
            if(line.length > 0){
                if (checkPrint(line,seats,location))
                    flag = true
            }

        }
        return flag;
    }

    private fun checkPrint(line: String, seats: String, location: String): Boolean {
        val dataChunks = line.split(",")
        val rname = dataChunks.get(1)
        val rstyle = dataChunks.get(2)
        val raddress = dataChunks.get(3)
        val rtablesCount = dataChunks.get(4)
        val tables = dataChunks.get(5)

        if(raddress.contains(location) && checkSeatsInTables(seats,tables)){
            println("--------------------------------***${rname}***--------------------------------\n")
            println("Location :- $raddress , Tables :- $rtablesCount, Restaurant Style :- $rstyle")
            println("Table Status :- Available")
            println("--------------------------------***~~~END~~~***--------------------------------\n")
            return true
        }
        return false
    }

    private fun checkSeatsInTables(seats: String, tables: String): Boolean {
        if(tables == null)
            return false
        return tables.contains(seats);
    }







    // Book Restaurant Table

    // 1st Function Frame
    fun bookRestaurantTable(username : String,restaurantName: String,seats : String,location : String){
        val isBooked : Boolean = getFileFromDirectory(restaurantName,seats,location);
        if(isBooked){
            println("$username your booking is done")
        }else{
            println("$username your booking is not possible :( due to some internal issue")
            println("Or someone else is already booked:( Please try on different location or restaurant")
            println("Please try again later :)")
        }



    }

    // 2nd Function Frame
    private fun getFileFromDirectory(restaurantName: String, seats: String, location: String) : Boolean{

            var isBooked : Boolean = false
            val dir = File(SELLERDIRECTORYPATH)
            val listFilesPath = dir.listFiles()
            if (listFilesPath != null){

                for (path in listFilesPath){
                    if(writeDataInTable(path.path,restaurantName,seats,location))
                        isBooked = true
                }

            }
        return isBooked;
    }

    // 3rd Function Frame
    private fun writeDataInTable(path : String,restaurantName: String, seats: String, location: String): Boolean {

        val reader = BufferedReader(FileReader(path));
        val iterator = reader.lineSequence().iterator()
        while (iterator.hasNext()){
            val line = iterator.next()
            if(line.length > 0){
                if (foundAndWrite(line,restaurantName,seats,location))
                {
                    return true
                }
            }

        }
        return false;
    }

    // 4th Function Frame
    private fun foundAndWrite(line: String,restaurantName: String, seats: String, location: String): Boolean {
        val dataChunks = line.split(",")
        var ownerName = dataChunks.get(0)
        val rname = dataChunks.get(1)
        val rtype = dataChunks.get(2)
        val rlocation = dataChunks.get(3)
        val tableCount = dataChunks.get(4)
        val tables = dataChunks.get(5)

        //Problem Detected :- Partially Resolved Lets see
        if(line.contains(seats) && line.contains(location)){
            if(checkSeatsInTablesAndBook(line,ownerName,seats,tables)){

                return true
            }
        }


        return false
    }

    // 5th Function Frame
    // Suspicious
    private fun checkSeatsInTablesAndBook(line : String,ownerName: String,seats: String, tables: String): Boolean {

        if(checkSeatIsAvailableInTable(seats,tables))
        {
            if(bookThisTableFrom(tables,"$SELLERDIRECTORYPATH/$ownerName.txt",line,seats))
                return true
        }

        return false
    }


    // Suspicious
    // 6th Function Frame
    private fun checkSeatIsAvailableInTable(seats: String, tables: String): Boolean {
        val dataChunks = tables.split("_");
        for (table in dataChunks){
            if(table.contains(seats) && table.contains("false"))
                return true
        }
        return false
    }

    // 7th Function Frame
    private fun bookThisTableFrom(tables : String,path: String, line: String, seats: String): Boolean {

        val data : String = checkReadAndUpdateData(tables,path,line,seats);


       if(data.length > 0){

           try{
               val bwriter : BufferedWriter = BufferedWriter(FileWriter(path,false));
               bwriter.write(data)
               bwriter.close()
           }catch (e : Exception){
               println(e)
           }
           return true
       }

        return false
    }

    // 8th Function Frame
    private fun checkReadAndUpdateData(tables : String,path: String, myline: String, seats: String): String {

        var flag = false
        var finalData = ""


        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                if(line == myline){
                    flag = true
                    finalData += updateTable(line,seats,tables)+"\n";
                }else
                    finalData += line+"\n"


            }

            reader.close()
        }catch (e : Exception){
            println(e)
        }




        if(flag)
            return finalData
        return ""

    }

    // 9th Function Frame
    private fun updateTable(line: String, seats: String,tables: String): String {
        var dataChunks = line.split(",")

        var oname = dataChunks.get(0)
        var rname = dataChunks.get(1)
        var rtype = dataChunks.get(2)
        var raddress = dataChunks.get(3)
        var rtableCount = dataChunks.get(4)
        var updatedTables = getUpdatedTables(tables,seats)


        return "$oname,$rname,$rtype,$raddress,$rtableCount,$updatedTables"

    }

    // 10th Function Frame
    private fun getUpdatedTables(tables: String, seats: String): Any {
        var dataChunks = tables.split("_")
        var result : String = ""
        for (table in dataChunks){
            if(table.contains(seats)){
                result += "($seats||true)_";
            }else{
                result += table+"_"
            }
        }

        return result.substring(0,result.length-1)
    }



    // Read Data Template
    private fun readData(path : String){
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
