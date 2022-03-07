package day2.java;

public class Teacher {

    private String name;
    private String teacherId;
    private Student []students;


    public Teacher(String name, String teacherId, Student[] students) {
        this.name = name;
        this.teacherId = teacherId;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
