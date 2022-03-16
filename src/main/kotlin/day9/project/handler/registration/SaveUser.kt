package day9.project.handler.registration

import day9.project.model.Admin
import day9.project.model.Customer
import day9.project.model.Seller
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


private const val REGISTER_USER_PATH = "E:/Internship Workspace/FULL Creative/Kotlin For Android Development/Kotlin-For-Android/src/main/kotlin/day9/project/database"
private const val REGISTER_CUSTOMER_PATH = REGISTER_USER_PATH+"/RegisteredUser.txt"
private const val REGISTER_ADMIN_PATH = REGISTER_USER_PATH+"/RegisteredAdmin.txt"
private const val REGISTER_SELLER_PATH = REGISTER_USER_PATH+"/RegisteredSeller.txt"

class SaveUser{

    fun saveCustomer(customer: Customer){
        val file : File = checkFile(REGISTER_CUSTOMER_PATH);

        val bwriter = BufferedWriter(FileWriter(REGISTER_CUSTOMER_PATH,true))
        val data ="${customer.username},${customer.emailId},${customer.password}\n"
        bwriter.write(data);
        bwriter.close()
        println("${customer.username} your registration is complete :)")
    }


    fun saveAdmin(admin : Admin){
        val file : File = checkFile(REGISTER_ADMIN_PATH);

        val bwriter = BufferedWriter(FileWriter(REGISTER_ADMIN_PATH,true))
        val data ="${admin.username},${admin.emailId},${admin.password}\n"
        bwriter.write(data);
        bwriter.close()
        println("${admin.username} your registration is complete :)")
    }


    fun saveSeller(seller : Seller){
        val file : File = checkFile(REGISTER_SELLER_PATH);

        val bwriter = BufferedWriter(FileWriter(REGISTER_SELLER_PATH,true))
        val data ="${seller.username},${seller.emailId},${seller.password}\n"
        bwriter.write(data);
        bwriter.close()
        println("${seller.username} your registration is complete :)")
    }

    private fun checkFile(registerUserPath: String): File {
        val file = File(registerUserPath)
        if(!file.exists())
            file.createNewFile()
        return file
    }


}
