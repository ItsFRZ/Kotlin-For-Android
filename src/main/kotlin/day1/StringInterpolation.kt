package day1

import java.util.*

fun main(){

    val scn = Scanner(System.`in`);
    val firstname : String = getFirstName(scn)
    val lastname : String = getLastName(scn)
    val nameLength : Int = getNameLength(firstname,lastname);
    val fullName : String = "${firstname} ${lastname}";
    println("Full Name is ${fullName} and length ${nameLength}")

    SumOfNumbers(5,7)

}

fun SumOfNumbers(a: Int, b: Int) {
    println("Sum of ${a} and ${b} is ${a+b}")
}

fun getNameLength(firstname: String, lastname: String): Int {

    return "${firstname}${lastname}".length;
}

fun getFirstName(scanner : Scanner): String {
    println("Firstname : ?")
    return scanner.nextLine().toString();
}

fun getLastName(scanner: Scanner): String {
    println("Lastname : ?")
    return scanner.nextLine().toString();
}

