package day2.oop

class SuperExtra() : Extra(){

     override fun dataExtraData(){
        super.dataExtraData()
    }

}

open class Extra() {

    open fun dataExtraData(){
        var data = "I have some data";
    }

}


fun main() {

}