package day4


class Hero(firstPower : String){

    val powers = arrayListOf<String>()

    init{
        powers.add(firstPower);
    }

}


infix fun Hero.showWith(power : String){
    powers.add(power);
    for(p in powers)
        print("$p ")
    println()
}

fun main(){

    val spidy = Hero("Crawling")

    spidy showWith "Webbings"
    spidy showWith "fly"

        
}
