package day7.backing

class Human(private var _name : String,private var _age : Int){

    var name : String
        get(){
            return _name
        }
        set(value){
            _name = value
        }
    var age  : Int
        get(){
            return _age
        }
        set(value){
            _age = value
        }



    fun info(){
        println("$_name , $_age")
    }
}



fun main() {

    val h1 = Human("Ron",22)
    h1.name = "Faraz"
    h1.age = 23
    h1.info()



}