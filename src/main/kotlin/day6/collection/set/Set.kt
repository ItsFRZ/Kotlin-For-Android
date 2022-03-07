package day6.collection.set


fun main() {


    val mySet = setOf<Int>(2,2,2,43,12,21,21,12);
    println(mySet)
    mySet.stream()


    val myMutableSet = mutableSetOf<Int>()
    myMutableSet.apply {

        add(10)
        add(20)
        add(10)
        add(20)
        add(30)
        add(20)
    }.forEach{
        println(it)
    }

    println(myMutableSet)

    val myHasSet = hashSetOf<Int>()
    with(myHasSet){
        add(10)
        add(20)
        add(10)
        add(20)
        add(30)
        add(20)
    }

    println(myHasSet)
}