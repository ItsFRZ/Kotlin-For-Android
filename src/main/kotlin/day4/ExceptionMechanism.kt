package day4


class NameTooShortException(message : String) : Exception(message)

fun parseMovieName(movie : String) : String{
     if(movie.length > 3)
         return movie.trim();
    try {
        throw NameTooShortException("Movie name is too short")
    }
    catch(e : Exception)
    {
        return e.message.toString()
    }finally {
        println("Operation completed Cleanup done :)")
    }
}

fun main(){

//    val movie1 = parseMovieName("Titanic")
    val movie2 = parseMovieName("AB")
    print(movie2)
}