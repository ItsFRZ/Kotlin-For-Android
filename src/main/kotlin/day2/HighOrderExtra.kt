package day2



class Data(private var data : String){
    fun fetch() : String{
        return data;
    }
}

fun Data.process() : String = this.fetch().toString().trim();



fun main() {

    val data = Data("  \t\tHello World\t\t  ");
    println("Message Print ${data.fetch()}")
    println("Mesaage Processed ${data.process()}")

}

