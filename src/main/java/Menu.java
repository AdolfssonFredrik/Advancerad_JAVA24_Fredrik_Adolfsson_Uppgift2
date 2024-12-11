import student.ClassList;
import student.Student;
import file.SaveToFile;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ClassList cl = ClassList.getInstance();

    final Pattern validGrades = Pattern.compile("^[A-F]$");
    final Pattern validStudentName = Pattern.compile("[A-Z]");
    final Pattern validStudentID = Pattern.compile("^\\d+$");

    public Menu() throws IOException {
        mainMenu();
    }

    public void mainMenu() throws IOException {
        System.out.println("|======Welcome to ClassList .inc!======|");
        System.out.println();
        System.out.println("Please select one of the following options:");
        System.out.println("  1. Add new student.");
        System.out.println("  2. Look up student with ID.");
        System.out.println("  3. Show all available students.");
        System.out.println("  4. Remove student with ID.");
        System.out.println("  5. Exit program.");


        while(true){
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("Add new student")){
                addNewStudentMenu();
            }
            else if(input.equalsIgnoreCase("Look up student with ID")){
                lookUpStudentWithIdMenu();
            }
            else if(input.equalsIgnoreCase("Show all available students")){
                showAllAvailableStudentsMenu();
            }
            else if(input.equalsIgnoreCase("Remove student with ID")){
                removeStudentWithID();
            }
            else if(input.equalsIgnoreCase("Exit program")){
                System.out.println("Closing program.");
                SaveToFile saveToFile = new SaveToFile();
                saveToFile.save("Students.JSON");
                System.exit(0);
            }
            else{
                System.out.println("Please enter a valid option.");
            }

        }

    }

    public void addNewStudentMenu() throws IOException {
        String studentName = "";
        String grade = "";
        String studentID = "";

        System.out.println("To add a new student you need to enter the students name, grade and ID");
        System.out.println("Please enter the name of the student: ");

        while(true){
            studentName = sc.nextLine();
            Matcher matcher = validStudentName.matcher(studentName);
            if(matcher.find()){
                System.out.println("Name is valid!");
                break;
            }
            else{
                System.out.println("Name is not valid!");
                System.out.println("Please enter a valid student name: ");
            }
        }


        System.out.println("Please enter the grade of the student: ");

        while(true){
            grade = sc.nextLine().toUpperCase();
            Matcher matcher = validGrades.matcher(grade);
            if(matcher.find()){
                System.out.println("Grade is valid!");
                break;
            }
            else{
                System.out.println("Grade is not valid!");
                System.out.println("Please enter a valid grade: ");
            }

        }

        System.out.println("Please enter the student ID: ");

        while(true){
            studentID = sc.nextLine();
            Matcher matcher = validStudentID.matcher(studentID);
            if(matcher.find()){
                System.out.println("StudentId is valid!");
                break;
            }
            else{
                System.out.println("StudentId is not valid!");
                System.out.println("Please enter a valid StudentId: ");
            }
        }

        cl.addStudent(studentName, Integer.parseInt(studentID), grade);

        mainMenu();

    }

    public void lookUpStudentWithIdMenu() throws IOException {
        System.out.println("Please enter the ID of the student: ");
        while(true){
            String studentID = sc.nextLine();
            Matcher matcher = validStudentID.matcher(studentID);

            boolean isMatch = matcher.find();


            if(!isMatch){
                System.out.println("StudentId is not valid! It has to be a number.");
                System.out.println("Please enter a valid StudentId: ");
            }
            else if(cl.getStudents().containsKey(Integer.parseInt(studentID))){

                Student s = cl.getStudent(Integer.parseInt(studentID));

                System.out.println("Student name: " + s.getName());
                System.out.println("Student grade: " + s.getGrade());
                break;
            }
            else if(!cl.getStudents().containsKey(Integer.parseInt(studentID))){
                System.out.println("Found no student with ID: " + studentID);
                System.out.println("Please enter a valid StudentId: ");
            }
            else{
                System.out.println("Student ID is not valid!");
                System.out.println("Please enter a valid StudentId: ");
            }
        }
        mainMenu();
    }

    public void showAllAvailableStudentsMenu() throws IOException {
        if(cl.getStudents().isEmpty()){
            System.out.println("There are no students to display.");
        }
        else{
            cl.getStudents().forEach((k, v) -> {
                System.out.println("|===Student ID: " + k + "===|");
                System.out.println("Student name: " + v.getName());
                System.out.println("Student grade: " + v.getGrade());
                System.out.println("|======================|\n");
            });
        }
        mainMenu();
    }

    public void removeStudentWithID() throws IOException {

        System.out.println("Please enter the ID of the student you want to remove: ");




        while(true){
            String input = sc.nextLine();
            Matcher matcher = validStudentID.matcher(input);

            boolean isMatch = matcher.find();

            if(!isMatch){
                System.out.println("StudentId is not valid! It has to be a number.");
                System.out.println("Please enter a valid StudentId: ");
            }

            else if(!cl.getStudents().containsKey(Integer.parseInt(input))){
                System.out.println("Found no student with ID: " + input);
                System.out.println("Please enter a valid StudentId: ");
            }
            else if(cl.getStudents().containsKey(Integer.parseInt(input))){
                System.out.println("Removing student with ID: " + input );
                cl.removeStudent(Integer.parseInt(input));
                break;
            }
            else{
                System.out.println("Student ID is not valid!");
                System.out.println("Please enter a valid Student ID: ");
            }
        }
        mainMenu();
    }
}
