package day18

import java.io.Serializable


fun main() {

//    printContent<String>("Hello World")
//    printContent<Int>(10)
//    printContent<Double>(34.433)



    printPrice(12)
    printPrice(12.4F)
    printPrice(43.4334)


}


fun <T> printContent(content : T){
    println("The content is $content")
}


fun <T> printPrice(no : T) where T : Number, T : Serializable {
    println("Price is $no")
}