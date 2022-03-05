package day5



var findMinimum: (Array<Int>) -> Int = { listNumber ->
    var number : Int = Int.MAX_VALUE

    for(i in listNumber)
    {
        if(number > i)
            number = i

    }
    number
}

val findIndex : (Array<Int>,Int) -> Int = { listNumber,item ->

    var low = 0
    var high = listNumber.size-1
    var index = -1
    while (low < high){
        val mid = (low+high)/2
        if(listNumber[mid] == item) {
            index = mid
            break
        }else if(item > listNumber[mid])
            low = mid+1
        else
            high = mid-1
    }
    index
}








var findLinearIndex : (Array<Int>,Int) -> Int = {
    array,item ->

    var index = -1

    for (i in array.indices)
    {
        if(array[i] == item) {
            index = i
            break
        }
    }


    index
}








fun main(){


    var minimumValue = findMinimum.invoke(arrayOf(12,437,87,9,1,2,-13,43))
    println("Minimum value from list is $minimumValue")


    var item = 41
    var binarySearch = findIndex(arrayOf(11,21,34,41,45,46,49,52,77,98,99),item)
    println("$item is found at index $binarySearch with the help of Binary Search Algorithm")


    var linearySearch = findLinearIndex(arrayOf(11,21,34,41,45,46,49,52,77,98,99),item)
    println("$item is found at index $linearySearch with the help of Linear Search Algorithm")





}


