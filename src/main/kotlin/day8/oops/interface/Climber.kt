package day8.oops.`interface`


interface Climber {
    fun climb()
}

open class Animal(){}
open class DomesticAnimal : Animal()
open class WildAnimal : Animal()
class Cat : DomesticAnimal() , Climber{
    override fun climb() {
        println("Cat can climb on trees, walls, etc")
    }
}
class Tiger : WildAnimal() , Climber{
    override fun climb() {
        println("Tiger can climb on trees, walls, etc")
    }
}
