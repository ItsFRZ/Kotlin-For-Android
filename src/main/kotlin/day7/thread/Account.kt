package day7.thread

import day4.practice.User


val records = mutableMapOf<String,List<String>>(
        "alex" to mutableListOf<String>("alex","123456","20000"),
        "ron" to mutableListOf<String>("ron","54321","10000")
)

class UserAccount(private var username : String,private var password : String){

    private var total : Int = 0;
    private var key : Boolean = false

    init{
        authenticate()
    }

    fun authenticate(){
        val data = records.get(username)
        if(data != null){
            if(username.equals(data.get(0)) && password.equals(data.get(1))){
                total = data.get(2).toInt()
                key = true
            }
        }
    }


    fun withDraw(amount : Int){
        if(key){
            if(amount < total){
                println("$username withdrawl $amount")
                total = total - amount
                doChanges(total);
                println("Total balance after withdrawl is $total")

            }else
                println("Not enough balance")
        }else
        {
            println("You are not authenticated")
        }
    }

    private fun doChanges(total: Int) {
        val newData = mutableListOf<String>(username,password,total.toString());
        records.remove(username)
        records.put(username,newData)
        key = false
    }


    fun balance(){
        println("Account balance is ${records.get(username)!!.get(2).toString()}")
    }

}

fun main() {

    val user1 = UserAccount("ron","54321")
    val user2 = UserAccount("ron","54321")


    user1.withDraw(2000)
    user2.withDraw(2000)

    user2.balance()



}