package day8.oops.enumeration

fun main() {

    val order = Order(MugSize.small)


    when(order.OrderSize){
        MugSize.large -> {
            println("Large cup of coffee with quantity ${order.OrderSize.quantity}")
        }
        MugSize.small -> {
            println("Small cup of coffee with quantity ${order.OrderSize.quantity}")
        }
        MugSize.medium -> {
            println("Medium cup of coffee with quantity ${order.OrderSize.quantity}")
        }
        MugSize.extraLarge -> {
            println("Extralarge cup of coffee with quantity ${order.OrderSize.quantity}")
        }
    }

}