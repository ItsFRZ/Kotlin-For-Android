package day1


class Person(){
    lateinit var name: String
    var age : Int? = null
}

fun main() {
    val p1 = Person()
    with(p1){

        try{
            println(age ?: 0)
            println(name)

        } catch(e : UninitializedPropertyAccessException){
            println("lateinint property is not initialized")
        }catch (e : Exception){

        }
    }


}