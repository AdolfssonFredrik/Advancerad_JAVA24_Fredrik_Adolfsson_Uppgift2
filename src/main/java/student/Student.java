package student;

public class Student {
    private final String name;
    private final int studentID;
    private String grade;

    public Student( int studentID, String name, String grade) {
        this.name = name;
        this.studentID = studentID;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getGrade() {
        return grade;
    }

    //Not currently used but can be used it the future to change the grade of a student
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
