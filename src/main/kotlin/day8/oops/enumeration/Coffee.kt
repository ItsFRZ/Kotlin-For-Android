package day8.oops.enumeration


enum class MugSize(val quantity : Int){
    small(120),
    medium(160),
    large(200),
    extraLarge(240)

}

class Order(var OrderSize : MugSize){


}