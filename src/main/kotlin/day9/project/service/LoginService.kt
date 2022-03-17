package day9.project.service

import day9.project.handler.login.FetchUser


private fun cleanList(list: Map<String, ArrayList<String>>): Map<String,String> {

    var myList  = mutableMapOf<String,String>()

    val iterator = list.iterator();
    while(iterator.hasNext()){
        val(username,data) = iterator.next();
        myList.put(username,data.get(2));
    }
    return myList;
}


class CustomerLoginService(){

    val fetchUser = FetchUser();
    fun getCustomerCredentials() : Map<String,String>{
       val list = fetchUser.getRegisteredCustomerList()
       val customersCredentials = cleanList(list);
       return customersCredentials;
    }


}
class AdminLoginService(){
    val fetchUser = FetchUser();
    fun getAdminCredentials() : Map<String,String>{
        val list = fetchUser.getRegisteredAdminList()
        val adminCredentials = cleanList(list);
        return adminCredentials;
    }
}

class SellerLoginService(){
    val fetchUser = FetchUser();
    fun getSellerCredentials() : Map<String,String>{
        val list = fetchUser.getRegisteredSellerList()
        val sellerCredentials = cleanList(list);
        return sellerCredentials;
    }
}