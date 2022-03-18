package day9.project.handler.customer

import day10.filehandling.readData
import day9.project.handler.seller.PersistOperations
import day9.project.userinterface.searchRestaurant
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

private const val ADDRESS = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day9/project/database/";
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

        if(rName.equals(restaurantName) && rAddress.equals(restaurantAddress))
            return true
        return false
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