import file.ReadFromFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFromFile readFromFile = new ReadFromFile();
        readFromFile.readFile("Students.JSON");
        new Menu();
    }
}
