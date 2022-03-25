package day14.handler

import day14.model.operation.Restaurant





// Paths

const val HOME = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day14/database";
const val SELLER = "$HOME/Seller.json"
const val USER = "$HOME/User.json"



// Database
var RESTAURANT_DB = ArrayList<Restaurant>();
var USER_DB = ArrayList<HashMap<String,String>>();

// Segregated Data
var CUSTOMER_DB =  ArrayList<HashMap<String,String>>()
var SELLER_DB =  ArrayList<HashMap<String,String>>()
var ADMIN_DB =  ArrayList<HashMap<String,String>>()




