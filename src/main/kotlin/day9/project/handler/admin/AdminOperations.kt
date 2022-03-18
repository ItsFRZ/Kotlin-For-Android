package day9.project.handler.admin

import day10.filehandling.readData
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


private const val ADDRESS = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day9/project/database/";


class AdminOperations() {


    // Print All Customer Details to Admin

    fun printAllCustomerDetail(username : String){
        val path : String = "${ADDRESS}/RegisteredUser.txt";
        var file = File(path)
        if(!file.exists())
        {
            println("Customers are not found!")
            return
        }

        println("----------------------------------****Customer's Info****----------------------------------")
        readDataAsTable(path);
        println("\n----------------------------------****~~~END~~~****----------------------------------")

    }

    private fun readDataAsTable(path: String) {

        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                val table = generateTable(line)
                println(table)
            }
            reader.close()
        }catch (e : Exception){
            println(e)
        }

    }

    private fun generateTable(line: String): String {
        var dataChunks = line.split(",")
        return "Customer Name:- ${dataChunks.get(0)}, Email Id:- ${dataChunks.get(1)}"
    }


    // Read data template

    fun readData(path : String){
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