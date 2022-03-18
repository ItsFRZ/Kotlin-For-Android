package day9.project.userinterface

import day9.project.controller.*
import day9.project.model.items.*
import java.lang.reflect.Executable


private var activeUser = currentUser;

fun sellerUI(){
   run();
}

private fun run(){
   println("Press 0 for All restaurants info")
   println("Press 1 to Add new Restaurant")
   println("Press 2 to Remove Restaurant")
   println("Press 3 to Add tables")
   println("Press 4 to Exit")
   //   println("Press 5 to Remove table")
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
         addNewRestaurant();
      }
      2->{
         removeRestaurant();
      }
      3->{
         addNewTable();
      }
//      4->{
//         removeExistingTable();
//      }
      else -> {
         return
      }
   }
}

//fun removeExistingTable() {
//   println("Enter restaurant name")
//   val restaurantName : String = readLine().toString().trim()
//   println("Enter no of table you want to remove for $restaurantName")
//   try{
//      val table : Int = readLine()?.toInt() ?: 0
//      removeTableRestaurant(activeUser,restaurantName,table);
//   }catch (e : Exception){
//      println("Please enter numeric value only")
//      removeExistingTable()
//   }
//
//}


fun addNewTable() {
   println("Enter restaurant name")
   val restaurantName : String = readLine().toString().trim()
   println("Enter no of seats for your new table")
   try{
      val seats : Int = readLine()?.toInt() ?: 0
      addTableRestaurant(activeUser,restaurantName,seats);
   }catch (e : Exception){
      println("Please enter numeric value only")
      addNewTable()
   }



}

fun removeRestaurant() {
   println("Enter Restaurant name ?")
   var restaurantName : String = readLine().toString().trim()
   removeRestaurant(activeUser,restaurantName)

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
   addRestaurantInfo(activeUser,name,type,address,tableCount,tables)


}

fun fillTables(restaurantName : String,tableCount : Int) : ArrayList<Tables>{



   val tableList = ArrayList<Tables>();

   for(i in 1..tableCount){

      println("Please enter no of seats for table $i of restaurant $restaurantName")
      var seats : Int = 0
      try{
         seats = readLine()?.toInt() ?: 0
      }catch (e : Exception){ println("Please enter only numeric value") }

      val table = Tables(seats,false);
      tableList.add(table);
   }
   return tableList
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
  displayAllRestaurantInfo(activeUser)
}

private fun continueRun(){
   println("Do you want to continue ? (Y/y)")
   val ans = readLine().toString()
   if(continueCheck(ans))
      run()
   return
}