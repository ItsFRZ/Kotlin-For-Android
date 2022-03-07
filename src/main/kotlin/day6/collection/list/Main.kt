package day6.collection.list


fun main() {


    var bikes = listOf("Apache","Pulsar","FZ")

    for(i in bikes.indices){
        println(bikes[i])
    }

    var superbikes : MutableList<String> = mutableListOf<String>()
    superbikes.add(0,"Hero")
    superbikes.add("FZ")
    superbikes.add("Yamaha")
    superbikes.removeLast()
    superbikes.removeFirst()


    val marbles = ArrayList<String>()
    marbles.add("Yellow")
    marbles.add("Red")
    marbles.add("Blue")
    marbles.clear()
    println(marbles)



}