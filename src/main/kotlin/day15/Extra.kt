package day15

//fun main() {
//
//// //Kotlin is Statically Typed Language
////    var globe = "Faraz"
////
////    globe = 24;
////
////    println(globe)
//
//
////Difference between == and === operator
//
////val name1 : String = "Faraz"
////val name2 : String = "Faraz"
////val name3 : String =name1
////
////println(name1 === name2)
//
////   val emp1  = Employe("Akash")
////   val emp2 = Employe("Akash")
////
////   println(emp1.name === emp2.name)
//
//// Access Modifier
//
//
//}

//open class Car(var name : String,price : String){
//    protected var _price : String = price;
////      var price = _price
////         get() {
////            field = _price
////            return field
////         }
////         set(value){
////            _price = value
////         }
//    protected fun increasePrice(value : Int){
//        val temp =  this._price.toInt() + value
//        this._price = temp.toString()
//    }
//
//
//}

//class SuperCar(name : String,price : String) : Car(name,price)


//fun main() {
////   val sup = SuperCar("Buggati Chiron","32120000")
////   println(sup.name)
//
//
////   val car = Car("Honda City","200000")
////   println(car._price)
//
//
////    val output =  if(10 > 20) 10 else 20
////
//
//
////   println(output)
//
//
//    val input = 10;
//
//
////    getRating(1)
////    getRating(2)
////    getRating(3)
////    getRating(4)
////    getRating(5)
////    getRating(6)
////    getRating(7)
////    getRating(8)
//
//}



//fun getRating(input : Int) : Unit{
//     when(input%5){
//        0,5 ->{
//            println("Best")
//        }
//        1 -> {
//            println("Worst")
//        }
//        2,3 -> {
//            println("Average")
//        }
//        4 -> {
//            println("Good")
//        }
//        else -> {
//            println(input)
//        }
//    }
//
//}




//
//class Employe(val name : String)


//class Configuration(var ram : String,var processor : String,var memory : String){
//
//    override fun toString(): String {
//        return "${ram}, ${processor}, ${memory}"
//    }
//
//}

//data class Mobile(var configuration : Configuration, var resolution : String)
//
//fun main() {
//
//    val config = Configuration("4gb","Snapdragon 855","Sata Sonic Memory")
//    val smartPhone = Mobile(config,"5.5");
//
//    val myPhone = smartPhone.copy(config,"")
//    myPhone.apply {
//        config.ram = "12gb"
//
//    }
//
//
//    println(config)
//    println(smartPhone)
//}




open class Wallet(var type : String, var company : String){
    fun clone() : Wallet{
        return Wallet(type,company)
    }

    override fun toString(): String {
        return "Type :- $type, Company:- $company"
    }
}

//fun main() {
////    val men1 = Wallet("Mens","Puma")
////    val women1 = Wallet("Ladies","Apple")
////    println(men1)
////    println(women1)
////
////
////    val men2 = men1
////    val men3 = men1.clone()
////    println(men1 === men2)
////    println(men1 === men3)
////
////
////
////     val node = Tree().Node();
////
//
//    val myClass = Tree::class
//    println(myClass)
//
//}


//class Tree(){
//
//    private val name : String = "Binary Search Tree"
//
//    inner class Node{
//        constructor(){
//            println(name)
//        }
//    }
//
//}

interface Leaf{

    fun myName (){
        println("Hello I am Leaffy")
    }

}


interface LeafOne{

    fun myName (){
        println("Hello I am Leaffy One")
    }

}


class MyTree : Leaf,LeafOne{
    override fun myName() {
        super<Leaf>.myName()

    }

}





fun main() {
//    val myTree = MyTree()
//    val myTreeOne : MyTree by lazy {
//        MyTree()
//    }
//
//    myTreeOne.myName()
//





    val myList = mutableListOf<Int>();
    myList.add(10);
    myList.add(30);
    myList.add(20);
    myList.add(40);
    myList.add(50);

    myList.sort();
    println(myList)


}


interface One {

    var myName : String;

    fun changeMyName(name : String) : String{
        myName = name;
        return myName.trim()
    }



}