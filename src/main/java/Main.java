import file.ReadFromFile;
import student.ClassList;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassList classList = ClassList.getInstance();

        ReadFromFile readFromFile = new ReadFromFile();
        readFromFile.readFile("Students.JSON");

        System.out.println(classList.getStudents().containsKey(12346));

        new Menu();
    }
}
