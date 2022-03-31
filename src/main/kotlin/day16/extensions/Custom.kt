package day16.extensions

// kotlin clases are by default final
final class Custom(private var fname : String,private var lname : String) {

   fun fullName() : String{
       return "$fname $lname"
   }

}

fun Custom.firstName() : String{
    val(fname,lname) = fullName().split(" ");
    return fname;
}

fun Custom.lastName() : String{
    val(fname,lname) = fullName().split(" ")
    return lname;
}


fun Custom.fullNameUpper() : String{
    return fullName().uppercase();
}

fun Custom.firstNameUpper() : String{
    return firstName().uppercase();
}

fun Custom.lastNameUpper() : String{
    return lastName().uppercase();
}



fun main() {

    val myName = Custom("Faraz","Sheikh");
//    myName.fullName();
    println(myName.fullName())
    println(myName.firstNameUpper())
    println(myName.lastNameUpper())

}