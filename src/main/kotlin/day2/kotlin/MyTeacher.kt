package day2.kotlin

import day2.java.*

class MyTeacher(var myTeacherName: String,var myTeacherId: String,var myTeacherStudents: Array<Student>) : Teacher(myTeacherName,myTeacherId,myTeacherStudents){
    fun displayTeacherStudentInfo() {
        println("-----------------*****$myTeacherName Info*****-----------------")
        println("Teacher is $myTeacherName and teacher's id is $myTeacherId")
        println("Total Students under $myTeacherName is ${getTotalStudents(myTeacherStudents)}")
        for (stud in myTeacherStudents){
            println("$myTeacherName teaches ${stud.name} and subjects are ${getSubjectListFor(stud)}")
        }
        println("-----------------*****End Of Info*****-----------------")
    }


}

fun MyTeacher.displayTeacherStudentInfo() {
    println("-----------------*****Teacher Info*****-----------------")
    print("Teacher is $myTeacherName and teacher's id is $myTeacherId")
    print("Total Students under $myTeacherName is ${getTotalStudents(myTeacherStudents)}")
    for (stud in myTeacherStudents){
        println("$myTeacherName teaches ${stud.name} all this subjects ${getSubjectListFor(stud)}")
    }
    println("-----------------*****End Of Info*****-----------------")
}

fun getSubjectListFor(student : Student) : String{

    val sb =  StringBuffer()
    for(subject in student.subjects){
        sb.append("_ $subject _")
    }

    return "{ ${sb.toString()} }";
}

fun getTotalStudents(student: Array<Student>) : Int{
    return student.size;
}

