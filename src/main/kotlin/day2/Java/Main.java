package day2.Java;

import day2.Kotlin.*;

public class Main {

    public static void main(String[] args) {

        String []engineeringSubjects = {
                "Maths","Software Engineering","Big Data","Image Processing","Data Structure","DBMS"
        };

        String []kohlisSubjects = {engineeringSubjects[0],engineeringSubjects[1],engineeringSubjects[3]};
        Student viratKohli = new Student("Virat Kohli","V#111",kohlisSubjects);

        String []ronaldosSubjects = {engineeringSubjects[0],engineeringSubjects[1],engineeringSubjects[2],engineeringSubjects[3],engineeringSubjects[5]};
        Student cristianoRonaldo = new Student("Cristiano Ronaldo","C#121",ronaldosSubjects);



        Student []ronsStudent = {viratKohli,cristianoRonaldo};
//        MyTeacherKt ron = new MyTeacherKt("Ron Cumbersome","Ron#2121",ronsStudent);
        MyTeacher ron = new MyTeacher("Ron Cumbersome","Ron#2121",ronsStudent);
        ron.displayTeacherStudentInfo();







    }

}
