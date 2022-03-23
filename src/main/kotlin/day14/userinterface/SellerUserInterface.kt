package day14.userinterface

import day14.contoller.RestaurantController
import kotlin.system.exitProcess




fun sellerUI(){
   run();
}

private fun run(){
   println("Press 0 for All restaurants info")
   println("Press 1 to Add new Restaurant")
   println("Press 2 to Remove Restaurant")
   println("Press 3 to Add tables")
   println("Press 4 to Remove tables")
   println("Press 5 to Logout")
   println("Press 6 to Exit")

   try {
      val choice = readLine()?.toInt() ?: 0
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
//         addNewRestaurant();
      }
      2->{
//         removeRestaurant();
      }
      3->{
//         addNewTable();
      }
      4->{
         logoutSeller();
      }
      5 -> {
         exitProcess(1)
      }
//      4->{
//         removeExistingTable();
//      }
      else -> {
         run()
      }
   }
}

fun showAllRestaurantInfo() {
   RestaurantController(currentUser).printAllRestaurantOfUser();
}

fun logoutSeller() {
   logoutUser("seller");
}
//
//fun addNewTable() {
//   println("Enter restaurant name")
//   val restaurantName : String = readLine().toString().trim()
//   println("Enter no of seats for your new table")
//   try{
//      val seats : Int = readLine()?.toInt() ?: 0
//
//   }catch (e : Exception){
//      println("Please enter numeric value only")
//      addNewTable()
//   }
//
//
//
//}
//
//fun removeRestaurant() {
//   println("Enter Restaurant name ?")
//   var restaurantName : String = readLine().toString().trim()
//
//}
//
//
//fun addNewRestaurant() {
//   println("Enter Restaurant name")
//   var name = readLine().toString()
//   println("Enter Restaurant Type")
//   var type = chooseRestaurantType()
//   println("Enter Restaurant Address")
//   var address = readLine().toString()
//   println("How many tables are in your $name")
//   var tableCount = 0
//   try{
//      tableCount = readLine()?.toInt() ?: 0
//   }catch (e : Exception){
//      println("Please enter only numeric value")
//      addNewRestaurant()
//   }
//
//
//}
//
//fun fillTables(restaurantName : String,tableCount : Int) : ArrayList<Tables>{
//
//
//
//   val tableList = ArrayList<Tables>();
//
//   for(i in 1..tableCount){
//
//      println("Please enter no of seats for table $i of restaurant $restaurantName")
//      var seats : Int = 0
//      try{
//         seats = readLine()?.toInt() ?: 0
//      }catch (e : Exception){ println("Please enter only numeric value") }
//
//      val table = Tables(seats,false);
//      tableList.add(table);
//   }
//   return tableList
//}
//
//
//fun chooseRestaurantType(): String {
//
//   println("Press 1 for Family Style")
//   println("Press 2 for Casual Dining")
//   println("Press 3 for Fine Dining")
//
//   var input = readLine()
//   if(input.equals("1"))
//      return RestaurantType.FamilyStyle.name
//   else if(input.equals("2"))
//      return RestaurantType.CasualDining.name
//   else if(input.equals("3"))
//      return RestaurantType.FineDining.name
//   else{
//      return chooseRestaurantType()
//   }
//}
//
//
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
