package day5


data class Bike(var name : String,var price : String,var color : String)


var sortByBikeName : (List<Bike>) -> Unit = {
    bikes ->
    bikes.sortedWith(compareBy<Bike>({it.name}))

}

val displayBikes : (List<Bike>) -> Unit = {
    bikes ->
    println("---------------------------------------------------------------------------------------")
    for(i in bikes.indices){
        println("${printBikes(bikes.get(i))}")
    }
    println("---------------------------------------------------------------------------------------")
}

val printBikes : (Bike) -> String = {
    bike ->
    val(name,price,color) = bike
    "Bike name is $name, color is $color and its price is $price"
}


fun chooseBike(){

    var bikes = mutableListOf<Bike>()
    bikes.add(Bike("Pulsar","88000","Black"))
    bikes.add(Bike("Passion","68000","Red-Black"))
    bikes.add(Bike("FZ","98000","Blue"))
    bikes.add(Bike("Kawasaki","188000","Red"))
    bikes.add(Bike("Duke","128000","Orange"))

    displayBikes(bikes)
    sortByBikeName.invoke(bikes)
    displayBikes(bikes)
//    sortByPrice()
//    sortByColor()

}



fun main() {

    chooseBike()

}