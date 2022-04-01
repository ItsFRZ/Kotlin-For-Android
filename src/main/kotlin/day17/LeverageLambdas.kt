package day17

import org.json.JSONArray
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.StringBuilder


const val PATH = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day17/files/data.json";

val myRestaurants = ArrayList<Map<String,String>>();

fun main() {

    val myData = loadJson(PATH) {
        readData(PATH)
    }

    println(myData)

}


fun loadJson(path : String,readDataString : (String) -> Unit) : String{

   

    val str = readDataString(path);


//    val arr = JSONArray(str);
//    println(arr)
    return str.toString();
}

fun readData(path : String) : String{

    val breader : BufferedReader = BufferedReader(FileReader(path));
    val myData  = StringBuilder()

    try{
        val iterator = breader.lineSequence().iterator();
        while (iterator.hasNext()){
            myData.append(iterator.next());
        }
    }catch (e : Exception){
        println(e)
    }finally {
        breader.close()
    }

    return myData.toString();
}

