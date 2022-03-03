package day3.types


data class Wallpaper(var name : String, var resolution : String,var category: String)

fun main(){

    val(n,r,c) = Wallpaper("Audi","4k","Cars")
    println("$n $r $c")
    println()


    val obj1 : Wallpaper = Wallpaper("Lykanhypersport","4k","Supercar")
    val obj2 : Wallpaper = obj1.copy("Buggati Cheron")


    println(obj1.toString())
    println(obj2)

}
