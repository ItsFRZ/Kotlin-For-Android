package day18.generics

open class Fruit
class Apple() : Fruit()

//class Box<out T>{
//    fun get() : T {}
//    fun set(item : T){}
//}

//fun main() {
////    val appleBox = Box<Apple>();
////    val box : Box<Fruit> = appleBox;
//
//
////    why return only ?
////    val appleBox = Box<Apple>();
////    val fruitBox : Box<Fruit> = appleBox;
////    fruitBox.set(Orange)
//
//}

class Orange() : Fruit()










/************************************************************/
//Contra Variance

open class Liquid

class Water : Liquid()


class Container<in T>{ // Consumer
    fun pourInContainer(item : T){
        println()
    }

//    fun getContainer() : T{
//
//    }
}

fun main() {

    val waterContainer = Container<Liquid>() // Parent

    val h2o : Container<Water> = waterContainer; // Child

}




