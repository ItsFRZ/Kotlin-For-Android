package day3


open class Vehicle {
    open fun startEngine(){
        println("Car engine is started")
    }
}
class BMW : Vehicle(){

    override fun startEngine(){
        println("BMW car engine is started")
        super.startEngine()
    }

}

class Audi : Vehicle(){

    override fun startEngine(){
        println("Audi car engine is started")
        super.startEngine()
    }

}


fun main(){

    val bmw : Vehicle = BMW()
    val audi : Vehicle = Audi()
    startCar(bmw)
    startCar(audi)

}


fun startCar(car : Vehicle){
    car.startEngine()
}
