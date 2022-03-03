package day3


data class Book(var name : String,var price : Int)

//Singleton
object Bookshelf{
    val books = arrayListOf<Book>();
    fun showMyBooksCollection(){
        for(i in 0..(books.size-1))
            println(books.get(i))

    }
}

class H2O(){

    companion object {

        const val molecularStructure : String = "H2O"

        fun callMe(){
            H2O()
            println("Scientific name of H2O is Water")
       }

    }

}


fun main(){

//    val b1 : Book = Book("Rich Dad Poor Dad",200)
//    val b2 : Book = Book("Head first with Kotlin",400)
//
//    Bookshelf.books.add(b1);
//    Bookshelf.books.add(b2);
//    Bookshelf.showMyBooksCollection()

    H2O.callMe()
    println(H2O.molecularStructure)


}