package jsonexercise1;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steve.exercise.model.ExerciceException;
import com.steve.exercise.model.PersonRecord;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class ProcessData {

    private ObjectMapper mapper;

    public ProcessData(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<PersonRecord> processJson(String Filename, int ageLimit,String city) {
        try {
            List<PersonRecord> personRecords = mapper.readValue(new File(Filename), new TypeReference<List<PersonRecord>>() {
            });

            return personRecords.stream()
                    .filter(x -> x.getAddress().getCity().equalsIgnoreCase(city))
                    .filter(m -> checkAge(m, ageLimit))
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
