package day19.game

sealed class Dice(name : String) {

    class One(val name : String) : Dice(name)
    class Two(val name : String) : Dice(name)
    class Three(val name : String) : Dice(name)
    class Four(val name : String) : Dice(name)
    class Five(val name : String) : Dice(name)
    class Six(val name : String) : Dice(name)

    fun rollDice() : String{
        return when(this){
            is Dice.One -> "Point is ${10}"
            is Dice.Two -> "Point is ${20}"
            is Dice.Three -> "Point is ${30}"
            is Dice.Four -> "Point is ${40}"
            is Dice.Five -> "Point is ${50}"
            is Dice.Six -> "Point is ${60}"

        }
    }
}

fun main() {
    val playGame = Dice.Two("Faraz");
    println(playGame.rollDice())

}

