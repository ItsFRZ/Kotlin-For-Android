package day9.project.handler.customer

import day10.filehandling.readData
import day9.project.handler.seller.PersistOperations
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

private const val ADDRESS = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day9/project/database/";
private const val SELLERDIRECTORYPATH = "$ADDRESS/seller"

class CustomerOperation {



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