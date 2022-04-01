package day16.inline


fun compute(){

//    var a = 10
//    var b = 12
//    var c = 14
//    var d = 16
//
//    val result = a++ == 11 && b-- == 11  || c-- == 13
//    println(result)
//    println(a)
//    println(b)
//    println(c)
//    println(d)



    var a = 12;
    var b = 30;
    var c = 10;
//          12 +  31  -  9  + 9  -  13
    var d = a++ + ++b - --c + c++ - a++;
    println(d)

}

fun main() {

//    calculateTime{
//        loop(1000000)
//    }


    compute()

}


inline fun calculateTime(func : () -> Unit){
    val startTime = System.currentTimeMillis();
    func();
    val endTime = System.currentTimeMillis();
    println("Time taken :- ${endTime-startTime} ms")

}

fun loop(n : Long){
    for(i in 1..n){
        //
    }
}
