package day8.oops.constructors


class Order{

    constructor(){
        println("Primary Constructor")
    }

    constructor(name : String) : this(){
        println("Secondary Constructor $name")

    }

    constructor(name : String,price : Int) : this(name){
        println("Tertiary Constructor $name $price")
    }
    init {
        println("First Init Block")
    }

    init{
        println("Second Init Block")
    }

    init{
        println("Third Init Block")
    }

}

