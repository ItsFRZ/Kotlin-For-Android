package day9.project.handler.admin

import day10.filehandling.writeData
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


private const val ADDRESS = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day9/project/database/";


class AdminOperations() {


    // Print All User Details to Admin

    fun printAllCustomerDetail(username : String){
        val path : String = "${ADDRESS}/RegisteredUser.txt";
        var file = File(path)
        if(!file.exists())
        {
            println("Customers are not found!")
            return
        }

        println("----------------------------------****User's Info****----------------------------------")
        readDataAsTable(path,"User");
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

                        /*Remove User*/

    // Remove default customer by Admin for specific reason
    fun removeDefaulterCustomer(username: String,customerName:String,emailId : String) {
        removeDefaulterUser(username,"User",customerName,emailId);
    }
    // Remove default Seller by Admin for specific reason
    fun removeDefaulterSeller(username: String,sellerName:String,emailId : String) {
        removeDefaulterUser(username,"Seller",sellerName,emailId);
    }


    fun removeDefaulterUser(username: String,userMode : String,targetName:String,emailId : String){
        val path : String = generatePath(userMode)
        var file = File(path)
        if(!file.exists())
        {
            println("$userMode's Info are not found!")
            return
        }
        var data = deleteDataAndGenerateData(path,targetName,emailId)
        deleteFileOf(path)
        writeData(path,data)
        println("$userMode $targetName is removed by Admin $username")

    }

    private fun generatePath(userMode: String): String {
        if (userMode.equals("customer") || userMode.equals("User"))
            return "$ADDRESS/RegisteredUser.txt"
        return "$ADDRESS/RegisteredSeller.txt"
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