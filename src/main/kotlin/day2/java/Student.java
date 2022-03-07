package day2.java;

public class Student {

    private String studentName;
    private String rollNumber;
    private String []subjects;

    public Student(String studentName, String rollNumber, String[] subjects) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
