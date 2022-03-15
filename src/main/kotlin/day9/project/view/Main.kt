package day9.project.view



fun main() {

    run();

}

fun run(){

    println("Press 1 for login")
    println("Press 2 for registration")
    println("Press 3 for Forget credentials")
    println("Press other range for exit")
    try{
        val choice = readLine()?.toInt()
        identifyInputChoice(choice)
    }catch(e : Exception){
        println("Enter number value only")
        if(repeat())
            run()
        return
    }

}


fun identifyInputChoice(choice : Int?){
   if(choice !is Int)
       throw Exception("Invalid input : Enter number range from 0..9")

    when(choice){

        1 -> {
          login()
        }
        2 -> {
          registration()
        }
        3 -> {
          forgetCredentials()
        }
        else -> {
            return
        }

    }
}

fun forgetCredentials() {
    println("forgetCredentials Not yet implemented")
}

fun registration() {
    println("registrationNot yet implemented")
}

fun login() {
    println("Press 1 For User Login")
    println("Press 2 For Restaurant Login")
    println("Press 3 For Admin Login")
    println("Press 4 to back")
    try{
        val choice = readLine()?.toInt()
        specifiedLoginInputChoice(choice)
    }catch(e : Exception){
        println("Enter number value only")
        if(repeat())
            run()
        return
    }


}

fun specifiedLoginInputChoice(choice: Int?) {
    if(choice !is Int)
        throw Exception("Invalid input : Enter number range from 0..9")

    when(choice){

        1 -> {
            loginUser()
        }
        2 -> {
            loginAdmin()
        }
        3 -> {
            loginRestaurant()
        }
        else -> {
            return
        }

    }
}

fun loginRestaurant() {
    println("Login Restaurant Admin Not yet implemented")
}

fun loginAdmin() {
    println("Login Admin Not yet implemented")
}

fun loginUser() {
    println("Login User Not yet implemented")
}


fun repeat() : Boolean{
    println("Do you want to continue (Y/N)")
    val cont = readLine().toString();
    if(cont.equals("Yes") || cont.equals("y") || cont.equals("Y") || cont.equals("yes"))
        return true
    return false
}
