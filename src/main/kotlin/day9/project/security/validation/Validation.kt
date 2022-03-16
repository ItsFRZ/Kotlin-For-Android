package day9.project.security.validation


open class Validation {

    private val EMAIL = Regex("^[\\w\\.]{3,20}@[\\w]{3,15}(\\.[a-z]{2,8})(\\.[a-z]{2,8})?\$")
    private val PASSWORD = Regex("^[\\w\\.\\#\\-]{5,32}\$")
    private val USERNAME = Regex("^[a-zA-Z0-9]{5,15}\$")
    private val ADDRESS = Regex("^[a-zA-Z0-9\\, ]{10,160}\$")
    private val PINCODE = Regex("^[0-9]{6}\$")
    private val MOBILENO = Regex("^([+0-9 ]{2,4})?([0-9]{10})\$")

    fun validateEmail(input : String) : Boolean{
        return EMAIL.matches(input)
    }

    fun validatePassword(input : String) : Boolean{
        return PASSWORD.matches(input)
    }

    fun validateUsername(input : String) : Boolean{
        return USERNAME.matches(input)
    }

    fun validateAddress(input : String) : Boolean{
        return ADDRESS.matches(input)
    }
    fun validatePincode(input : String) : Boolean{
        return PINCODE.matches(input)
    }

    fun validateMobileNumber(input : String) : Boolean{
        return MOBILENO.matches(input)
    }


    fun emailHelp(){
        println("Please enter valid email address (example : robin@email.com)")
    }

    fun passwordHelp(){
        println("Password should between 5-32 alphanumeric characters")
        println("# - . are allowed in password")
    }

    fun addressHelp(){
        println("Please enter valid address character should between 10 to 160 range")
    }

    fun usernameHelp(){
        println("Username should contain alphanumeric value of range 5-15 characters")
    }

    fun pincodeHelp(){
        println("Only Indian pincode is acceptable currently should contain 6 digit numerical value")
    }

    fun mobileNumberHelp(){
        println("Only Indian mobile numbers is accepting currently should be contain valid values")
        println("Ex (+91 9129212912)")
        println("Ex (9129212912)")

    }



}