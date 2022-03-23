package day14.handler


import day14.model.registration.User
import org.json.JSONArray
import org.json.JSONObject
import java.io.File


//Paths
const val HOME = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day14/database";
const val USER = "$HOME/User.json"


//DB
private var USER_DB = HashMap<String,ArrayList<String>>();



fun getUserList() :HashMap<String,ArrayList<String>> {

    val rawData : String = readData(USER);

    if (rawData.length <= 0)
        return USER_DB;

    val jsonArray = JSONArray(rawData);
    for (i in 0 until jsonArray.length()){

        val jsonObject = jsonArray.getJSONObject(i);
        val uid = jsonObject.getString("uid")
        val username = jsonObject.getString("username")
        val usermode = jsonObject.getString("usermode")
        val password = jsonObject.getString("password")
        val email = jsonObject.getString("email")

        val userData = ArrayList<String>()
        userData.add(uid);
        userData.add(username);
        userData.add(password);
        userData.add(usermode);
        userData.add(email);

        USER_DB.put(username,userData);
    }
    return USER_DB;
}

fun generateUniqueId() : String{
    return (getUserList().size+1).toString();
}


fun persistUser(user : User) : Boolean{

    val previousData = readData(USER);

    var finalData : String = ""
    val jsonObject = JSONObject(user);

    if(!previousData.isEmpty())
    {
        val jsonArray = JSONArray(previousData);
        finalData = jsonArray.put(jsonObject).toString();

    }else{

        finalData = "[$jsonObject]"
    }


    var file = File(USER)
    if (file.exists())
        file.delete()

    if(writeData(USER,finalData)){
        return true
    }

    return false

}
