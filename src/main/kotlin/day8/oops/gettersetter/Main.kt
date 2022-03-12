package day8.oops.gettersetter


fun main() {

    val admin = Admin()
    admin.apply {
        firstName = "Faraz"
        lastName = "Sheikh"
        println("$firstName $lastName")
    }


}
