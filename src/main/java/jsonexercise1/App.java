package jsonexercise1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.steve.exercise.model.PersonRecord;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ObjectMapper mapper = JsonMapper.builder().build();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ProcessData data = new ProcessData(mapper);
        List<PersonRecord> personRecords = data.processJson("/Users/steve/Documents/Java/jsonexercise1/src/main/resources/sample.json", 20,"romford");
        System.out.println(personRecords);
    }
}
