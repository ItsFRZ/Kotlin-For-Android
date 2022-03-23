package day14.handler

import java.io.*

fun readData(path : String) : String{
    val file = File(path);
    if(!file.exists())
        file.createNewFile();

    var breader : BufferedReader? = null
    val result = StringBuilder();

    try{
        breader = BufferedReader(FileReader(path));
        val iterator = breader.lineSequence().iterator();
        while (iterator.hasNext()){
            result.append(iterator.next())
        }


    }catch (e : Exception){
        println("Something went :( wrong")
        println("IO exception occured")
    }finally {
        breader?.close() ?: ""
    }

    return result.toString();
}

fun writeData(path : String,data : String) : Boolean{

    val file = File(path);
    if(!file.exists())
        file.createNewFile();

    var isComplete : Boolean = false

    var bwriter : BufferedWriter? = null;
    try{
        bwriter = BufferedWriter(FileWriter(path));
        bwriter.write(data);
        isComplete = true
    }catch (e : Exception){
        println("Something went :( wrong")
        println("IO exception occured")
    }finally {
        bwriter?.close() ?: ""
    }

    return isComplete;
}
