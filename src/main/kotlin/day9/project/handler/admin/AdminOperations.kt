package day9.project.handler.admin

import day10.filehandling.readData
import day10.filehandling.writeData
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
        readDataAsTable(path,"Customer");
        println("\n----------------------------------****~~~END~~~****----------------------------------")

    }

    private fun readDataAsTable(path: String,usermode : String) {

        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                val table = generateTable(line,usermode)
                println(table)
            }
            reader.close()
        }catch (e : Exception){
            println(e)
        }

    }

    private fun generateTable(line: String,usermode : String): String {
        var dataChunks = line.split(",")
        return "$usermode Name:- ${dataChunks.get(0)}, Email Id:- ${dataChunks.get(1)}"
    }



    // Print all Seller's info to Admin
    fun printAllSellerDetail(username : String){
        val path : String = "${ADDRESS}/RegisteredSeller.txt";
        var file = File(path)
        if(!file.exists())
        {
            println("Seller's Info are not found!")
            return
        }

        println("----------------------------------****Seller's Info****----------------------------------")
        readDataAsTable(path,"Seller");
        println("\n----------------------------------****~~~END~~~****----------------------------------")

    }


    // Remove default customer by Admin for specific reason
    fun removeDefaulterCustomer(username: String,customerName:String,emailId : String){
        val path : String = "${ADDRESS}/RegisteredUser.txt";
        var file = File(path)
        if(!file.exists())
        {
            println("Customer's Info are not found!")
            return
        }
        var data = deleteDataAndGenerateData(path,customerName,emailId)
        deleteFileOf(path)
        writeData(path,data)
        println("Customer $customerName is removed by Admin $username")

    }

    private fun deleteFileOf(path: String) {
        val file = File(path);
        if(!file.exists())
            return

        file.delete()
    }

    private fun deleteDataAndGenerateData(path: String,customerName:String,emailId : String): String{

        var result : String = ""
        try{
            val reader = BufferedReader(FileReader(path));
            val iterator = reader.lineSequence().iterator()
            while(iterator.hasNext()){
                val line = iterator.next()
                if(!line.contains(customerName) && !line.contains(emailId))
                    result += line+"\n"
            }
            reader.close()
        }catch (e : Exception){
            println(e)
        }
        return result;
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