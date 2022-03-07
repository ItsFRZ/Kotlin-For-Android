package day3.interfacelearing


interface MyClickListener{
    // Properties in an interface should be abstract so that we cannot initialize
    var name : String
    val age : String

    fun onClick(){
        println("Button is Clicked")
    }

    fun onTouch()

}

interface MyDoubleClickListener{
    fun onClick(){
        println("Button is Clicked")
    }

    fun onTouch()
}

class Button() : MyClickListener,MyDoubleClickListener{

    override var name : String = ""
    override val age: String = ""


    override fun onClick() {
        super<MyClickListener>.onClick()
    }

    override fun onTouch() {
        println("Button is Touched")
    }

}

fun main(){
    val btn : Button = Button()
    btn.onClick()
    btn.onTouch()
}