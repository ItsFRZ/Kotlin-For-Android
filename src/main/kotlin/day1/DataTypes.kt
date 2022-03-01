package day1

import java.util.*
fun main(){


//    for(i in 1..5){
//        login()
//    }

    studentRegister();
}

fun studentRegister() {

    println("Student Registration ")
    val obj = Scanner(System.`in`)
    print("\nEnter name : ")
    val name : String = obj.nextLine();
    print("\nEnter age : ")
    val age : Int = obj.nextInt()
    print("\nEnter Secondary Percentage : ")
    val secondaryPercentage : Float = obj.nextFloat()
    print("\nEnter Branch Name you want : ")
    obj.nextLine()
    val branch : String = obj.nextLine()
    print("\nAre you physically disabled (Y/N) : ")
    val disability : Boolean =  checkDisability(obj)
    previewDetails(name,age,secondaryPercentage,branch,disability);


}

fun previewDetails(name: String, age: Int, secondaryPercentage: Float, branch: String, disability: Boolean) {
    println("-------------------------------------------------------------------------------------------------")
    println("Student Information Preview")
    println("-------------------------------------------------------------------------------------------------")
    println("Name is ${name}, age is ${age}")
    println("Your secondary percentage is ${secondaryPercentage}%")
    println("And you want ${branch} branch")
    println("Do you have any physical disablity ${disabilityMessage(disability)}")
    println("-------------------------------------------------------------------------------------------------")

}

fun disabilityMessage(disability: Boolean): String {
    if(disability)
        return "Yes"
    else return "No"
}

fun checkDisability(obj: Scanner): Boolean {

    val answer : String = obj.nextLine();
    return answer.equals("Y") or answer.equals("y") or answer.equals("Yes") or answer.equals("yes")
}

fun login() {
    val obj =  Scanner(System.`in`)
    println("Enter Username")
    val username : String = obj.nextLine()
    println("Enter Password")
    val password : String = obj.nextLine()
    checkCredentials(username,password)

}
fun checkCredentials(username: String, password: String) {

    val userPattern = Regex("^[A-Za-z]{3,20}@[a-z]{3,20}\$")
    val passwordPattern = Regex("^[0-9]{8,40}\$")

    var userFlag : Boolean = validateUserName(userPattern,username);
    var passwordFlag : Boolean = validatePassword(passwordPattern,password);

    if(userFlag && passwordFlag)
        homePage()
    else{
        if(!userFlag)
            userNameHelp()
        else
            passwordHelp()
    }
}
fun validateUserName(pattern : Regex,username : String ) : Boolean{
    return username.contains(pattern)
}
fun validatePassword(pattern : Regex,password : String ) : Boolean{
    return password.contains(pattern)
}
fun passwordHelp(){
    println("------------------------------------------------------------------------------------------")
    println("Password should be more than 7 characters and less then 40 characters with only numeric value")
    println("Example username \nexample 1 : 6565621232\nexample 2 : 435341212\nexample 3 : 535352053535")
    println("------------------------------------------------------------------------------------------")

}
fun userNameHelp(){
    println("------------------------------------------------------------------------------------------")
    println("Username should be more than 2 characters and less then 20 characters with @ in between")
    println("Numerical character is not allowed in username")
    println("Example username \nexample 1 : user@name\nexample 2 : john@doe\nexample 3 : hello@world")
    println("------------------------------------------------------------------------------------------")

}

fun homePage(){
    print("Welcome to SquareChat Web Portal")
}



