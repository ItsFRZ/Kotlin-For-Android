package day6.companion

fun main(){
    val user1 : Website = Website()
    user1.registrationPage()
    user1.contactPage()

    val user2 : Website = Website()
    user2.loginPage()
    user2.productsPage()

    val user3 : Website = Website()
    user3.registrationPage()
    user3.loginPage()
    user3.logoutPage()

    val user4 : Website = Website()
    user4.registrationPage()

    val user5 : Website = Website()
    user5.registrationPage()
    user5.contactPage()
    user5.logoutPage()

    APICounter.websiteStats()

}

class APICounter{
    companion object{
        var totalApiHit : Int = 0
        var registration : Int = 0

        fun websiteStats(){
            println("Total API Hit's are $totalApiHit")
            println("Registered User are $registration")
        }

    }


}

class Website
fun Website.homePage(){ APICounter.totalApiHit += 1 }
fun Website.loginPage(){ APICounter.totalApiHit += 1 }
fun Website.contactPage(){APICounter.totalApiHit += 1}
fun Website.logoutPage(){APICounter.totalApiHit += 1}
fun Website.registrationPage(){
    APICounter.totalApiHit += 1
    APICounter.registration += 1
}
fun Website.productsPage(){APICounter.totalApiHit += 1}
