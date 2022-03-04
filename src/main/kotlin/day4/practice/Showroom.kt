package day4.practice

open class Showroom(val department: Department){



    private fun showCase(department: Department){
        val cars = department.getCars();
        println("----------------------------------------------------------")
        for(key in cars.keys)
        {
            println(cars.get(key))
        }
        println("----------------------------------------------------------")
    }

    fun showCase(){
//        val sales = Department("akash@gmail.co.in","12345")
        showCase(department)
    }



}