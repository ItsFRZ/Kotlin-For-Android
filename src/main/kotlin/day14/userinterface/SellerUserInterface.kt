package day14.userinterface

import day14.contoller.RestaurantController
import day14.model.operation.RestaurantType
import day14.model.operation.Table

import kotlin.system.exitProcess




fun sellerUI(){
   run();
}

private fun run(){
   println("Press 0 for All restaurants info")
   println("Press 1 to Add new Restaurant")
   println("Press 2 to Remove Restaurant")
   println("Press 3 to Logout")
   println("Press 4 to Exit")
   var choice : Int = 10;
   try {
      choice = readLine()?.toInt() ?: 7
      choiceMaker(choice);
   }catch (e : Exception){
      println("Please enter numeric value only")
      continueRun()
   }


}

private fun choiceMaker(choice: Int) {
   when(choice){
      0->{
         showAllRestaurantInfo();
      }
      1->{
         addNewRestaurant();
      }
      2->{
         removeRestaurant();
      }
      3->{
         logoutSeller();
      }
      4 -> {
         exitProcess(1)
      }
      else -> {
         run()
      }
   }
}


fun removeRestaurant() {
   println("Enter Restaurant name ?")
   var restaurantName : String = readLine().toString().trim()
   RestaurantController(currentUser).removeRestaurant(restaurantName);
}

fun addNewRestaurant() {

   println("Enter Restaurant name")
   var name = readLine().toString()
   println("Enter Restaurant Type")
   var type = chooseRestaurantType()
   println("Enter Restaurant Address")
   var address = readLine().toString()
   println("How many tables are in your $name")
   var tableCount = 0

   try{
      tableCount = readLine()?.toInt() ?: 0
   }catch (e : Exception){
      println("Please enter only numeric value")
      addNewRestaurant()
   }

   var tables = fillTables(name,tableCount);
   RestaurantController(currentUser).addRestaurantOfUser(name,type,address,tableCount.toString(),tables)


}

fun chooseRestaurantType(): String {

   println("Press 1 for Family Style")
   println("Press 2 for Casual Dining")
   println("Press 3 for Fine Dining")

   var input = readLine()
   if(input.equals("1"))
      return RestaurantType.FamilyStyle.name
   else if(input.equals("2"))
      return RestaurantType.CasualDining.name
   else if(input.equals("3"))
      return RestaurantType.FineDining.name
   else{
      return chooseRestaurantType()
   }

}


fun showAllRestaurantInfo() {
   RestaurantController(currentUser).printAllRestaurantOfUser();
}

fun logoutSeller() {
   logoutUser("seller");
}

fun fillTables(restaurantName : String,tableCount : Int) : ArrayList<Table>{



   val tableList = ArrayList<Table>();

   for(i in 1..tableCount){

      println("Please enter no of seats for table $i of restaurant $restaurantName")
      var seats : Int = 0
      try{
         seats = readLine()?.toInt() ?: 0
      }catch (e : Exception){ println("Please enter only numeric value") }

      val table = Table(i.toString(),booked = "false",seats.toString(),"NA","NA");
      tableList.add(table);
   }
   return tableList
}

private fun continueRun(){
   println("Do you want to continue ? (Y/y)")
   val ans = readLine().toString()
   if(continueCheck(ans))
      run()
   return
}

fun continueCheck(ans: String): Boolean {
   if(ans.equals("Y") || ans.equals("y"))
      return true
   return false
}
