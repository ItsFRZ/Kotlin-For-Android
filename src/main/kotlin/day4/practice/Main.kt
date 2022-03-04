package day4.practice


fun main(){

    val department : User = Department("akash@gmail.co.in","12345")
    val showroom = Showroom(department as Department)
    val customer = Customer(department)

    department.addCar()
    customer.showCase()



}