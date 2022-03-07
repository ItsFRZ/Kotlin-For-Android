package day6.HigherLevelFunctions



class Race{

    var candidateName : String? = null
    var candidateHeight : Float? = null

    fun startRun() : Unit{
       println("$candidateName started running");
    }
}

fun main(){
    val c1 = Race()
    val c2 = Race()

//    c1.candidateName = "Faraz Sheikh"
//    c1.candidateHeight = 6.1F

    with(c1){
        candidateHeight = 6.1F
        candidateName = "Faraz"
    }

    c1.apply {  }.startRun()


}