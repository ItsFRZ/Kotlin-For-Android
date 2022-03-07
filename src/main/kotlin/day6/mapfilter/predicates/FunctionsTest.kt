package day6.mapfilter.predicates


fun main() {
    val list = listOf(12,21,5,6,10,11,2,3,4,1);
    val predicateLogic : (Int) -> Boolean = {num -> num < 10}

    val filtered = list.filter(predicateLogic)
    val squared = filtered.map{num -> num * num}
    val all : Boolean = list.all(predicateLogic)
    val count : Int = list.count{no:Int -> no < 10}
    val find : Int? = list.find(predicateLogic)
    val any : Boolean = list.any(predicateLogic)

    println(filtered)
    println(squared)
    println(all)
    println(any)
    println(find)
    println(count)


}