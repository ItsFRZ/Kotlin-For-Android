package day14.handler

import day14.model.registration.User
import day14.model.registration.UserRegistration
import org.json.JSONArray
import org.json.JSONObject
import java.io.File


fun registerHandler(username:String, password : String,contactType : String,email : String) : Boolean {
    val contactId = generateUniqueContactId();
    return persistUser(UserRegistration(contactId,username,contactType,email,password))
}


fun generateUniqueContactId() : String{
    return (LoadData().getUserList().size+1).toString()
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
