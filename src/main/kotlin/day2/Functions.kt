package day2

fun main(){

//    println(functionName("saveRelationalData"))
//    helloWorld()

//    Default Parameter
//    println(printUserName("John","Frost"))
//    println(printUserName("John"))

//    Named Argument
    println(volume("Record box",1,height = 10,width = 5))

//    Single Expression Function
    println("Addition ${addNumbers(2,5)}")
}

fun functionName(parametersWithType : String) : String /*Return Type*/{

    return "Function name is $parametersWithType"
}

// Kotlin function must need to return thats why by default return type is Unit
fun helloWorld() : Unit{
    println("Hello World")
}

fun printUserName(firstName : String,lastName : String = "Doe") : String{
    return "$firstName $lastName"
}

//Named Argument
fun volume(boxName : String,length : Int,width : Int,height : Int) : Int{
    print("$boxName volume is : ")
    return length*width*height;
}

// Single Expression
fun addNumbers(x : Int,y : Int) : Int = x+y


