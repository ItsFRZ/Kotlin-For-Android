package day11.generics


fun <T> printContent(content : T) {
    println(content)
}



class Printer<T : Number>(){

    fun printContent(content : T){
        println("The content is : $content")
    }

    fun someOtherFunction(value : T) {
        println("Some other function $value")
    }

}

fun main() {


//    printContent<String>("Hello World")
//    printContent<Int>(10)


    val printer = Printer<Int>();
    printer.printContent(12)




//    println(serviceNotWorked("Hello World"))
//    println(serviceNotWorked(""))

}


fun serviceNotWorked(content : String) : Any?{
    if(content.isEmpty())
        return null;
    return content;
}