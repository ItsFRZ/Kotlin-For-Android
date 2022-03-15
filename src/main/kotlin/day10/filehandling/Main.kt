package day10.filehandling

import java.io.*


const val PATH : String = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day10/fileoutput/";



fun main() {

//    var file : File = createFile("${PATH}Faraz.txt")
//    println(file)

//    val data : String = "Hello World this is Faraz Sheikh"
//    writeData("${PATH}Faraz.txt",data);
    readData("${PATH}Faraz.txt")
}


fun createFile(fileName : String) : File{

    var file = File(fileName)
    if(file.exists())
    {
        file.delete()
    }

    if(file.createNewFile())
        println("File is Created")
    return file
}

fun writeData(filePath : String,fileData : String){
    try{
        val bwriter : BufferedWriter = BufferedWriter(FileWriter(filePath,true));
        bwriter.write(fileData)
        bwriter.close()
        println("Writing operation successfully finished")
    }catch (e : Exception){
        println(e)
    }
}

fun readData(path : String){
    try{
      val reader = BufferedReader(FileReader(path));
      val iterator = reader.lineSequence().iterator()
      while(iterator.hasNext()){
          val line = iterator.next()
          println(line)
      }
      reader.close()
    }catch (e : Exception){
        println(e)
    }
}



