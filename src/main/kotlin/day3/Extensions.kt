package day3.types


class Laptop(var name : String,var price : String)


fun Laptop.getLaptopInfo() : String = "$name $price"

fun Int.getEven() : Int{
    if(this%2 == 0)
        return this
    else return this+1
}


fun main(){
    println(Laptop("Asus","37900").getLaptopInfo())

    val x : Int = 11;
    var even = x.getEven()
    println(even)
}
