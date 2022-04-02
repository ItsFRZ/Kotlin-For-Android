package day14.handler

import day14.model.registration.User
import day14.model.registration.UserRegistration
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.util.*


fun registerHandler(username:String, password : String,contactType : String,email : String) : Boolean {
    val contactId = generateUniqueContactId();
    return persistUser(UserRegistration(contactId,username,contactType,email,password))
}


fun generateUniqueContactId() : String{
    return getSecret();
}

fun getSecret(): String {

    val size : Int = (LoadData().getUserList().size+1)
    val currentMilli = System.currentTimeMillis()
    val hour = Date().hours
    val randomNo = getRandom(1,1000);

    return "${Math.abs((currentMilli.toInt() + size)+(randomNo+hour))}"
}


fun getRandom(min : Int,max : Int): Int{
    return (Math.random() * (max-min) + min).toInt()
}



fun persistUser(user : User) : Boolean{

    val previousData = readData(USER);

    var finalData : String = ""
    val jsonObject = JSONObject(user);

    if(!previousData.isEmpty())
    {
        val jsonArray = JSONArray(previousData);
        finalData = jsonArray.put(jsonObject).toString(4);

    }else{

        val jsonArray = JSONArray().put(jsonObject)
        finalData = jsonArray.toString(4)
    }


    var file = File(USER)
    if (file.exists())
        file.delete()

    if(writeData(USER,finalData)){
        return true
    }

    return false

}
