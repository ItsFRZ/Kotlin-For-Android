package day2

fun main() {

    val java = JavaClient();
    val nums : Array<Int> = java.numbers;
    java.getEven()
    java.getOdd()

}

fun JavaClient.getEven(){
    for (i in numbers) {
        if(i%2==0)
            print("$i ")
    }
    println()
}

fun JavaClient.getOdd(){
    for (i in numbers) {
        if(i%2!=0)
            print("$i ")
    }
    println()
}