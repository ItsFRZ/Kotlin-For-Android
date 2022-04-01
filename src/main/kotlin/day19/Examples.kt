package day19

enum class Rating(mean : String) {
    ONE("Poor"),
    TWO("Average"),
    THREE("Good"),
    FOUR("Better"),
    FIVE("Best");


    fun getRating() = println("Rating is ${this.name}")

}

fun main() {


    val rating = Rating.ONE
    rating.getRating()


    for(rating in Rating.values()){
        println(rating)
    }

    println()
    println()
    println()

    choiceMaker();



}

class RatingNotFoundException(msg : String) : Exception(msg)

fun choiceMaker(){
    println("Press 1 for Poor")
    println("Press 2 for Average")
    println("Press 3 for Good")
    println("Press 4 for Better")
    println("Press 5 for Best")



    try{
        val choice : Int = readLine().toString().toInt()

        if (choice < 1 || choice > 5)
            throw RatingNotFoundException("Please enter proper rating")

        when(choice){
            1 -> Rating.ONE.getRating()
            2 -> Rating.TWO.getRating()
            3 -> Rating.THREE.getRating()
            4 -> Rating.FOUR.getRating()
            5 -> Rating.FIVE.getRating()
        }

    }catch (e : RatingNotFoundException){
        println(e);

        choiceMaker()
    }catch (e : Exception){
        println()

        choiceMaker()
    }


}