package day4



class Numeric(var no : Int){



    fun addAll(vararg nos : Int) : Int{
        var sum : Int = 0
        for(i in nos)
            sum += i
        return sum

    }

    infix fun addOne(num : Int) : Int = no+num

}

fun main(){

    val num = Numeric(10)
    var ans = num addOne 20
    println(ans)


    println("Sum of all ${num.addAll(10,20,30,40,50,60)}")
}

