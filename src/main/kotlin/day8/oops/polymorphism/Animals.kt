package day8.oops.polymorphism

open class Animal{
    open fun makeSound(){
        println("Generic animal sound")
    }
}

open class DomesticAnimal : Animal(){}
open class WildAnimal : Animal(){}

class Dog(): DomesticAnimal(){
    override fun makeSound(){
        println("Dog barking sound")
    }
}

class Cat(): DomesticAnimal(){
    override fun makeSound() {
        println("Cat meowing sound")
    }
}

class Tiger : WildAnimal(){
    override fun makeSound() {
        println("Tiger roaring sound")
    }
}

