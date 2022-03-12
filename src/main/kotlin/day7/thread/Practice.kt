package day7.thread



object Computation : Thread(){
    val list = listOf(1,2,3,4,5,6)
    fun addition() : Int{
        var total = 0
        for(i in list)
            total += i
        return total
    }
    fun multiplication() : Int{
        var total = 1
        for(i in list)
            total *= i
        return total
    }
    override fun run() {
        synchronized(this){

            val addition = addition()
            val multiplication = multiplication()
            compute(addition,multiplication)
        }
    }

    fun compute(addition : Int,multiplication :  Int){
        println("Difference between multplication and addition of list is ${multiplication-addition}")
    }



}
fun main() {




    Computation.start()



}