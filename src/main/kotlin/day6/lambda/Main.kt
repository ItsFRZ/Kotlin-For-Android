package day6.lambda


class Program{

    fun addTwoNumbers(a : Int,b : Int) : Unit{
        val sum = a + b;
        println("$sum")
    }

    fun addTwoNumbers(a : Int,b : Int, execute : Listener){
        val sum = a+b
        execute.action(sum)
    }

    fun addTwoNumbers(a : Int,b : Int, execute : (Int) -> Unit){
        execute(a+b)
    }


}

interface Listener{
    fun action(sum : Int)
}

fun main() {

    val program = Program()
    program.addTwoNumbers(12,12)
    program.addTwoNumbers(12,12,object : Listener{
        override fun action(sum: Int) {
            println("$sum")
        }

    })

    program.addTwoNumbers(12,12,{ sum -> println(sum) })


}