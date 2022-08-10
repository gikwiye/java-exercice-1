package jsonexercise1;

import com.steve.exercise.model.Record;

import java.util.List;

public interface IOReader {

    /**
     * The read function reads data from different inputs.
     * @param param contains all connection/file name information
     * @return List of Objects.
     */
    List<? extends Record> read(InputParam param);
}
