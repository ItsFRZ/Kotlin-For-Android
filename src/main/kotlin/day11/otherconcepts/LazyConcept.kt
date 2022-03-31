package day11.otherconcepts


val pi : Double by lazy{
    3.14
}

val data : String by lazy{
    "Faraz Sheikh"
}


fun data(){

//    print("Some data")
    print(data+" "+pi)

}

fun main() {
    data()



}