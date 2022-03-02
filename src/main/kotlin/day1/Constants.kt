package day1

// public static final in java
const val STUDENTNAME  = "Faraz"


fun main(){

//    val studentName : String = getName();
//    println(studentName)


//    print(STUDENTNAME)
//    valCheck()
//    varCheck()


}

fun valCheck(){
    val i = 1
    while(i <= 10){
        print("$i ")
//        i++
    }
}


fun varCheck(){
    var i = 1
    while(i <= 10){
        print("$i ")
        i++
    }
}


fun getName() : String{
    return "Faraz";
}
