package day3

import java.util.*
import kotlin.collections.ArrayList

private val usernamePattern = Regex("^[a-zA-Z]{3,16}$")
private val passwordPattern = Regex("^[a-z0-9]{3,16}$")
private val books = mutableMapOf<String,ArrayList<String>>();

open class Authenticate{

    protected fun credentialsCheck(username : String,usernamePattern : Regex,password: String,passwordPattern : Regex) : Boolean {
        var uflag = false
        var pflag = false
        if(username.matches(usernamePattern))
            uflag = true
        if(password.matches(passwordPattern))
            pflag = true

        return authenticate(uflag,pflag)
    }

    private fun authenticate(uflag : Boolean,pflag : Boolean) : Boolean{
        if(uflag && pflag){
            return true;
        }else {
            if(!uflag)
                userNameHelp()
            else
                passwordHelp()
        }
        return false
    }

    private fun passwordHelp() {
        println("Password should be in small character which ranges from 3 to 16 character")

    }

    private fun userNameHelp(){
        println("Username should not contain numerical character and username ranges from 3 to 16 character")
    }

}

class Admin(username : String,password : String) : Authenticate(){



    private var username : String? = null;
    private var password : String? = null;

    init{
        this.username = username
        this.password = password
    }

    fun authenticate() : Boolean{
        val flag : Boolean = credentialsCheck(this.username ?: "" ,usernamePattern,this.password ?: "",passwordPattern)
        if(!flag)
            return false
        return true
    }




}

class Customer{

}


open class Library {


    constructor(admin : Admin){
        println("Press 1 for add book")
        println("Press 2 for read book")
        val obj = Scanner(System.`in`)
        val choice = obj.nextInt()
        obj.nextLine()
        when(choice)
        {
            1 -> {
                println("Enter book name")
                val bookName = obj.nextLine()
                println("Enter author name")
                val authorName = obj.nextLine()
                println("Enter price")
                val price = obj.nextLine()
                println("Enter published year")
                val year = obj.nextLine()

                addBooks(bookName,authorName,price.toInt(),year.toInt())

            }

            2 -> {
                println("Enter book name")
                val bookName = obj.nextLine()
                readBook(bookName)
            }
            else -> {
                println("Invalid Input")
            }
        }
    }

    constructor(customer: Customer){
        println("Press 1 for read book")

        val obj = Scanner(System.`in`)
        val choice = obj.nextInt()
        obj.nextLine()
        when(choice)
        {
            1 -> {
                println("Enter book name")
                val bookName = obj.nextLine()
                readBook(bookName)
            }
            else -> {
                println("Invalid Input")
            }
        }
    }

    private fun addBooks(bookName:String,authorName : String,price : Int,year : Int){
        val list  = ArrayList<String>()
        list.add(bookName)
        list.add(authorName)
        list.add(price.toString())
        list.add(year.toString())
        books.put(bookName,list)
        println("$bookName added successfully")
    }


    private fun readBook(bookName: String){
        val bookData = books.contains(bookName);
        if(!bookData)
        {
            println("$bookName is not available in library")
            return
        }

        println("Reading Book")
        println(books.getValue(bookName))
    }



}


fun main(){

       run()

}

fun run(){

    val admin = Admin("Faraz","12345")
    val user = Customer()
    val library = Library(admin)
    println("Do you want to continue (Y/N)")
    val obj = Scanner(System.`in`)
    val ans = obj.nextLine()
    if (ans.equals("Y") || ans.equals("y")) {
        run()
    }else
        return

}