package day6.mapfilter

data class Team(var name: String,var country : String)

fun main() {

    val teams : List<Team> = listOf(
            Team("Kohli","India"),
            Team("Pant","India"),
            Team("Aktar","Pakistan"),
            Team("Warner","Australia")
    )

    val india = teams.filter{ it.country.equals("India") }.map{it.name}
    println(india)


    val numbers = listOf<Int>(1,2,100,20,21,6,3,4,120);
    val smallNumbers = numbers.filter{it <= 10}
    println(smallNumbers)

    val squared = smallNumbers.map { it*it }
    println(squared)






}

