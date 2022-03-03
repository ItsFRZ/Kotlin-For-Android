package day3


interface Footballer{

    fun kick();
    fun dribble(){
        println("Footballer is dribbling")
    }


}


open class Human(val name : String)

class Stud (name : String) : Human(name) , Footballer{

    override fun kick() {
        println("$name kicked for goal")
    }

}

fun playFootball(footballer : Footballer){
    footballer.kick()
    footballer.dribble()
}

fun printName(human: Human){
    println(human.name)
}


fun main(){

    val stud = Stud("Faraz")
    playFootball(stud)
    printName(stud)

}