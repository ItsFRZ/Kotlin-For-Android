package day8.oops.doubtsolving

enum class Medals(val cashPrize : String){Gold("25 Lakh"),Silver("15 Lakh"),Bronze("5 Lakh"),Platinum("100 Lakh")}


class Olympic(val medalType : Medals)

fun Olympic.prizeMoney(){
    when(medalType){
        Medals.Gold -> {
            println("First runner win ${medalType.name} medal with cash prize ${medalType.cashPrize}")
        }
        Medals.Bronze -> {
            println("Second runner win ${medalType.name} medal with cash prize ${medalType.cashPrize}")
        }
        Medals.Silver -> {
            println("Third runner win ${medalType.name} medal with cash prize ${medalType.cashPrize}")
        }
        else -> {
            println("VIP runner win ${medalType.name} medal with cash prize ${medalType.cashPrize}")
        }
    }
}
fun main() {

    val firstRunnerUp = Olympic(Medals.Platinum)
    firstRunnerUp.prizeMoney()

}

