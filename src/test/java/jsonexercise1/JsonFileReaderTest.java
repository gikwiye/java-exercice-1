package jsonexercise1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.steve.exercise.model.Address;
import com.steve.exercise.model.PersonRecord;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonFileReaderTest {

    private JsonFileReader jsonFileReader;

    @Before
    public void init(){
        ObjectMapper mapper = JsonMapper.builder().build();
        jsonFileReader = new JsonFileReader(mapper);
    }


    @Test
    public void processJson_success() throws ParseException {


        String filename = "/Users/steve/Documents/Java/jsonexercise1/src/test/resources/sampleTest.json";
        Address address = new Address();
        address.setCity("Romford");
        address.setStreet("Ashmour Gardens");
        address.setPostCode("RM1 4RH");
        address.setCountry("");
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse("08/10/1990");
        PersonRecord personRecord = new PersonRecord();
        personRecord.setName("Steve Ngabo");
        personRecord.setDob(dob);
        personRecord.setAddress(address);
        personRecord.setNi("S123456");
        personRecord.setSalary(new BigDecimal("7000.5"));
        InputParam param = new InputParam(filename, address.getCity(), 20);
        List<PersonRecord> actual = jsonFileReader.read(param);
        assertThat(actual.size()).isEqualTo(1);

        assertThat(actual.get(0)).usingRecursiveComparison().ignoringFields("dob").isEqualTo(personRecord);
    }

}