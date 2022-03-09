package day6


open class Human(){
    fun info(){
        println("Human Class")
    }
}


object Person : Human(){
    private var name : String? = null
    private var isStudent : Boolean? = null


    fun getInfo() : String{
        if(isStudent ?: false)
            return "Student name is $name"
        return "Person name is $name"
    }

    fun setInfo(name : String,isStudent : Boolean):Unit{
        this.name = name
        this.isStudent = isStudent
    }

}


fun main() {

    Person.setInfo("Faraz",true)
    Person.info()
    println("${Person.getInfo()}")

}