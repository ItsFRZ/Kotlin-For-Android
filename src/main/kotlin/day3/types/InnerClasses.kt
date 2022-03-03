package day3.types

// Inner class concept
class Employe(var name : String){
    inner class ESOP(){

        fun getEmployeName(){
           println("ESOP of employee name $name is 1200$")
        }

    }
}



// Anonymous classes
open class Space{

    open fun planets(){
        println("Total we have 8 planets in our solar system")
    }
    open fun stars() {
        println("Infinite no of stars")
    }
    open fun blackholes(){
        println("Mystery unknown")
    }

}


interface Robot{
    fun think()
}

fun main(){

//    Inner class concept
//    Employe("Rohan").ESOP().getEmployeName()

//    let do minor change in class
    val space = object : Space() {

        override fun planets(){
            println("Total we have 9 planets in our solar system")
        }
    }
    space.planets()

    val robo : Robot = object : Robot{
        override fun think() {
            println("I also think")
        }
    }

    robo.think()
}


//Anonymous classes is used in event listener