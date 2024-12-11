package saveToFile;

import Student.ClassList;
import Student.Student;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;


public class SaveToFile {
    ClassList cl = ClassList.getInstance();


    public void save(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ArrayNode array = mapper.createArrayNode();
        Object[] s = cl.getStudents().keySet().toArray();

        for(Object key : s){
            Student student = cl.getStudents().get(key);
            ObjectNode obj = mapper.createObjectNode();


            obj.put("StudentID", student.getStudentID());
            obj.put("Name:", student.getName());
            obj.put("Grade:", student.getGrade());

            array.add(obj);
        }
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), array);


    }


}
