package student;

import java.util.HashMap;

public class ClassList {
    private static ClassList instance;


    //Using HashMap for efficiency in looking up students
    private HashMap<Integer, Student> students;


    private ClassList() {
        this.students = new HashMap<>();
    }


    public static ClassList getInstance() {
        if (instance == null) {
            instance = new ClassList();
        }
        return instance;
    }

    public void removeStudent(int id) {
        students.remove(id);
    }

    public void addStudent(String name, int studentID, String grade) {
        this.students.put(studentID , new Student(studentID, name, grade));
    }

    public Student getStudent(int studentID) {
        if(this.students.containsKey(studentID)) {
            return this.students.get(studentID);
        }
        return null;
    }

    public HashMap<Integer, Student> getStudents() {
        return this.students;
    }
}
