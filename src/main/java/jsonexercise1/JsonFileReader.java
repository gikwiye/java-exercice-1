package jsonexercise1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steve.exercise.model.ExerciceException;
import com.steve.exercise.model.PersonRecord;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFileReader implements IOReader{

    private final ObjectMapper mapper;

    public JsonFileReader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<PersonRecord> read(InputParam param) {
        return processJson(param);
    }
    public List<PersonRecord> processJson( InputParam param) {
        try {
            List<PersonRecord> personRecords = mapper.readValue(new File(param.getFileName()), new TypeReference<List<PersonRecord>>() {
            });

            return personRecords.stream()
                    .filter(x -> x.getAddress().getCity().equalsIgnoreCase(param.getCity()))
                    .filter(m -> checkAge(m, param.getAge()))
                    .distinct()
                    .collect(Collectors.toList());

        } catch (IOException | NullPointerException e) {
            throw new ExerciceException("Failed to read json file", e);
        }

    }

    private boolean checkAge(PersonRecord personRecord, int ageLimit) {
        LocalDate currentDate = LocalDate.now();
        LocalDate localDate = personRecord.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period diff = Period.between(localDate, currentDate);
        return diff.getYears() >= ageLimit;
    }
}
