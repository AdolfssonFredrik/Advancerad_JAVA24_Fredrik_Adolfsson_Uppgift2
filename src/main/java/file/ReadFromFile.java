package file;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import student.ClassList;


public class ReadFromFile {
    public void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        ClassList cl = ClassList.getInstance();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(file);

        if(node.isArray()) {
            for(JsonNode j : node) {
                cl.addStudent(j.get("Name:").asText(), j.get("StudentID").asInt(), j.get("Grade:").asText());
            }
        }
    }
}
