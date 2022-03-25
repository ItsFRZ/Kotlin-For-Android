package day6.lambda


class Operations{


    fun add(no1 : Int,no2 : Int,execute : (Int,Int) -> Int){
        println(execute(no1,no2))
    }

    fun multiply(no1 : Int,no2 : Int,func : (Int,Int) -> Int) : Unit{
        func(no1,no2)
    }

    fun multiplyAll(numbers : Array<Int>,operate : (Array<Int>) -> Int){
        var result = operate(numbers)
        println("Result $result")
    }

}

fun main(){

    var result : Int = 0

    val operations = Operations()
    operations.multiplyAll(arrayOf(1,2,3,4,5,6)){ arr ->
        var sum = 1
        for(i in arr)
            sum *= i
        result = sum
        result
    }

    val action : (Int,Int) -> Int = {
        no1,no2 ->
        no1+no2
    }
    operations.add(12,12,action)


    println("$result")


    val utilityMethod = Utility()
    utilityMethod.reversed(
        "Faraz",
        {
            it.reversed()
        },
    )

}


class Utility{

    fun reversed(str : String,action : (String) -> String){
        println(action(str))
    }

}
