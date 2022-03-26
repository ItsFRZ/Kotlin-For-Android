package day14.handler

import day14.model.operation.Restaurant
import day14.model.operation.Table
import day14.model.registration.UserMode
import day14.model.registration.UserRegistration
import org.json.JSONArray




fun loginHandler(username:String, password : String) : UserRegistration{

    LoadRestaurantData()

    val loadALLData = LoadData();
    val getAllData = loadALLData.getUserList();
    val userData : HashMap <String,String> = HashMap();


    var isUser = false

    for(user in getAllData){
        if(user.get("username").equals(username) && user.get("password").equals(password))
        {
            isUser = true
            userData.put("username",user.get("username").toString())
            userData.put("password",user.get("password").toString())
            userData.put("contactType",user.get("contactType").toString())
            userData.put("email",user.get("email").toString())
            userData.put("contactId",user.get("contactId").toString())
            break
        }
    }


    val username = userData.get("username").toString()
    val password = userData.get("password").toString()
    val contactType = userData.get("contactType").toString()
    val email = userData.get("email").toString()
    val contactId = userData.get("contactId").toString()
    return UserRegistration(contactId, username, contactType, email, password)
}





class LoadData(){


    init {
        //Check this is also
        USER_DB.clear();
        loadUserList()
    }

    fun getUserList() :  ArrayList<HashMap<String,String>>{
        return USER_DB;
    }



    private fun loadUserList() : ArrayList<HashMap<String,String>>{

        val rawData : String = readData(USER);

        if (rawData.length <= 0)
            return USER_DB;

        val jsonArray = JSONArray(rawData);
        for (i in 0 until jsonArray.length()){

            val jsonObject = jsonArray.getJSONObject(i);
            val contactId = jsonObject.getString("contactId")
            val username = jsonObject.getString("username")
            val contactType = jsonObject.getString("contactType")
            val password = jsonObject.getString("password")
            val email = jsonObject.getString("email")


            var myMap= HashMap<String,String>();
            myMap.put("contactId",contactId)
            myMap.put("username",username);
            myMap.put("contactType",contactType);
            myMap.put("password",password);
            myMap.put("email",email);
            USER_DB.add(myMap);

        }
        return USER_DB;
    }



    private fun loadCustomerList() :  ArrayList<HashMap<String,String>> {

        var customerList =  ArrayList<HashMap<String,String>>();

        val iterator = USER_DB.iterator();
        while (iterator.hasNext()){
            var it = iterator.next();
            if(it.get("contactType").equals(UserMode.Customer.name))
            {
                val customer = HashMap<String,String>();
                customer.put("contactId",it.get("contactId").toString())
                customer.put("password",it.get("password").toString())
                customer.put("contactType",it.get("contactType").toString())
                customer.put("email",it.get("email").toString())
                customer.put("username",it.get("username").toString())
                customerList.add(customer)

            }

        }



        return customerList;

    }
    fun getCustomerList () :ArrayList<HashMap<String,String>>{
        CUSTOMER_DB = loadCustomerList();
        return CUSTOMER_DB;
    }



    private fun loadSellerList() : ArrayList<HashMap<String,String>>{

        var sellerList =  ArrayList<HashMap<String,String>>();
        USER_DB.map {

            if(it.get("contactType").equals(UserMode.Seller.name))
            {
                val seller = HashMap<String,String>();
                seller.put("contactId",it.get("contactId").toString())
                seller.put("password",it.get("password").toString())
                seller.put("contactType",it.get("contactType").toString())
                seller.put("email",it.get("email").toString())
                seller.put("username",it.get("username").toString())
                sellerList.add(seller)

            }

        }

        return sellerList;

    }
    fun getSellerList() : ArrayList<HashMap<String,String>>{
        SELLER_DB = loadSellerList()
        return SELLER_DB
    }


    private fun loadAdminList() : ArrayList<HashMap<String,String>>{

        var adminList =  ArrayList<HashMap<String,String>>();
        USER_DB.map {

            if(it.get("contactType").equals(UserMode.Admin.name))
            {
                val admin = HashMap<String,String>();
                admin.put("contactId",it.get("contactId").toString())
                admin.put("password",it.get("password").toString())
                admin.put("contactType",it.get("contactType").toString())
                admin.put("email",it.get("email").toString())
                admin.put("username",it.get("username").toString())
                adminList.add(admin)

            }

        }

        return adminList;

    }
    fun getAdminList() : ArrayList<HashMap<String,String>>{
        ADMIN_DB = loadAdminList()
        return ADMIN_DB
    }


}


class LoadRestaurantData(){

    init{
        RESTAURANT_DB.clear()
        loadRestaurantList();
    }

    private fun loadRestaurantList() : ArrayList<Restaurant>{

        val rawData : String = readData(SELLER);

        if (rawData.length <= 0)
            return RESTAURANT_DB;

        try{

            val jsonArray = JSONArray(rawData);
            for (i in 0 until jsonArray.length()){

                val jsonObject = jsonArray.getJSONObject(i);
                val contactId = jsonObject.getString("contactId")
                val restaurantName = jsonObject.getString("restaurantName")
                val restaurantType = jsonObject.getString("restaurantType")
                val restaurantAddress = jsonObject.getString("restaurantAddress")
                val noOfTables = jsonObject.getString("noOfTables")
                val tablesBooked = jsonObject.getString("tablesBooked")
                val tables : ArrayList<Table> = getAllTables(jsonObject.getJSONArray("tables"))

                RESTAURANT_DB.add(Restaurant(contactId,restaurantName,restaurantType,restaurantAddress,noOfTables,tablesBooked,tables));

            }

        }catch (e : Exception){
            println(e)
        }

        return RESTAURANT_DB;
    }

    private fun getAllTables(jsonArray: JSONArray): ArrayList<Table> {
        val tables  = ArrayList<Table>();
        for (i in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(i);
            val tableId : String = jsonObject.getString("tableId")
            val isBooked : String = jsonObject.getString("isBooked")
            val seats : String = jsonObject.getString("seats")
            val bookedDate : String = jsonObject.getString("bookedDate")
            val bookedBy : String = jsonObject.getString("bookedBy")
            tables.add(Table(tableId, isBooked, seats, bookedDate, bookedBy))

        }
        return tables;
    }

}