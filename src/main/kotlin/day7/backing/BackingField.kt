package day7.backing

class NotEligibleException(msg : String) : Exception(msg)
class Voting{

    var age : Int = 17
        get(){
            try{
                if(field < 18)
                    throw NotEligibleException("Age should be greater then 17")
            }catch(e : NotEligibleException){
                println(e.message)
            }
            return field
        }
        set(value){
            try{
                if(value < 18)
                    throw NotEligibleException("Age is not valid")
            }catch(e : NotEligibleException){
                println(e.message)
            }
            field = value
        }

}

fun main() {

    val v1 = Voting()
    v1.age = 21
    println(v1.age)


}
