package day13.operations

import org.json.JSONArray
import java.io.*


fun fetchDataFromFile(path : String) : String{


    val file = File(path);
    if(!file.exists())
        return ""

    val result = StringBuilder();
    var breader : BufferedReader? = null;

    try{
        breader = BufferedReader(FileReader(path));
        val iterator = breader.lineSequence().iterator();
        while (iterator.hasNext()){
            val line = iterator.next();
            result.append(line);
        }

    }catch (e : Exception){
        println("Something went wrong :(\n\\: Probably IO Exception occur's")

    }finally {
        breader?.close() ?: ""
    }


    return result.toString();

}


const val DB_TEACHER = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day13/operations/DB.json"
val teacherDB : HashMap<String,Teacher> = fetchDataFromJson();


fun fetchDataFromJson() : HashMap<String,Teacher>{

    val json = fetchDataFromFile(DB_TEACHER);
    val teachers = HashMap<String,Teacher>();

    val jsonArray = JSONArray(json);
    for(i in 0 until jsonArray.length()){
        val jsonObject = jsonArray.getJSONObject(i);
        val teacherId : String = jsonObject.getString("teacherId");
        val name : String = jsonObject.getString("name");
        val age : String = jsonObject.getString("age");
        val department : String= jsonObject.getString("department");
        val subjects : ArrayList<String> = getJsonSubjectArray(jsonObject.getJSONArray("subjects"));
        val studentCounts : String = jsonObject.getString("studentsCount")


        teachers.put(teacherId,Teacher(teacherId,name,age,department,subjects,studentCounts))

    }
    return teachers;
}

fun getJsonSubjectArray(jsonArray: JSONArray): ArrayList<String> {
    val subject  = ArrayList<String>()
    for (i in 0 until jsonArray.length()){
        subject.add(jsonArray.get(i).toString())
    }
    return subject;
}

fun pushDataIntoJson(){

    println("Enter teacher id");
    val tid = readLine().toString()
    println("Enter department new name");
    val department = readLine().toString()
    println("Enter Student Counts new name");
    val studCount = readLine().toString()
    val target : Teacher? = teacherDB.get(tid);

    with(target){
        if(this != null){
            this.department = department;
            this.studentCount = studCount
        }
    }

    val newData = pushObjectstoJsonString(teacherDB);
    writeData(newData, DB_TEACHER);



}

fun writeData(teacher : String,path : String){
    val file = File(path)
    if(!file.exists())
        return
    var bwriter : BufferedWriter? = null
    try{
        bwriter = BufferedWriter(FileWriter(path))
        bwriter.write(teacher);
        println("Data base updated")
    }catch (e : Exception){
        println("Something :( went wrong \n:// IO Exception occurs")
    }finally {
        bwriter?.close() ?: "";
    }


}

fun pushObjectstoJsonString(teacherDB: HashMap<String, Teacher>) :String{

    val teacherList = JSONArray()
    teacherList.put(teacherDB);
    return teacherList.toString();
}


fun main() {
    fetchDataFromJson();
    pushDataIntoJson()
}