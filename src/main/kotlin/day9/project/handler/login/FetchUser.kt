package day9.project.handler.login

import java.io.BufferedReader
import java.io.FileReader


private const val REGISTERED_USER_PATH = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day9/project/database"
private const val REGISTERED_CUSTOMER_PATH = REGISTERED_USER_PATH+"/RegisteredUser.txt"
private const val REGISTERED_ADMIN_PATH = REGISTERED_USER_PATH+"/RegisteredAdmin.txt"
private const val REGISTERED_SELLER_PATH = REGISTERED_USER_PATH+"/RegisteredSeller.txt"





class FetchUser(){
    private val registeredCustomersDB = mutableMapOf<String,ArrayList<String>>()
    private val registeredAdminDB = mutableMapOf<String,ArrayList<String>>()
    private val registeredSellerDB = mutableMapOf<String,ArrayList<String>>()

    fun getRegisteredCustomerList() : Map<String,ArrayList<String>> {
        loadRegisteredCustomerFromFile()
        return registeredCustomersDB;
    }

    fun getRegisteredAdminList() : Map<String,ArrayList<String>> {
        loadRegisteredAdminFromFile()
        return registeredAdminDB;
    }

    fun getRegisteredSellerList() : Map<String,ArrayList<String>> {
        loadRegisteredSellerFromFile()
        return registeredSellerDB;
    }

    private fun loadRegisteredSellerFromFile() {

        try{

            val breader = BufferedReader(FileReader(REGISTERED_SELLER_PATH))
            val iterator = breader.lineSequence().iterator()


            while (iterator.hasNext())
            {
                val line : String = iterator.next();
                cleanLoad(line,registeredSellerDB);
            }
            breader.close()
        }catch (e : Exception){
            println(e)
        }

    }

    private fun loadRegisteredAdminFromFile() {

        try{

            val breader = BufferedReader(FileReader(REGISTERED_ADMIN_PATH))
            val iterator = breader.lineSequence().iterator()


            while (iterator.hasNext())
            {
                val line : String = iterator.next();
                cleanLoad(line,registeredAdminDB);
            }
            breader.close()
        }catch (e : Exception){
            println(e)
        }

    }

    fun loadRegisteredCustomerFromFile(){
        try{

            val breader = BufferedReader(FileReader(REGISTERED_CUSTOMER_PATH))
            val iterator = breader.lineSequence().iterator()


            while (iterator.hasNext())
            {
                val line : String = iterator.next();
                cleanLoad(line,registeredCustomersDB);
            }
            breader.close()
        }catch (e : Exception){
            println(e)
        }

    }

    private fun cleanLoad(line: String, registeredCustomersDB: MutableMap<String, ArrayList<String>>) {
        var chunks = line.split(",")
        val(username,email,password) = chunks
        val list = arrayListOf<String>();
        list.add(username);
        list.add(email)
        list.add(password)
        registeredCustomersDB.put(username,list)
    }


}