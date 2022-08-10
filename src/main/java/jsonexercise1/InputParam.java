package jsonexercise1;

public class InputParam {


    private String fileName;
    private String tableName;
    private String connectionString;

    private String city;
    private int age;

    public InputParam(String fileName, String city, int age) {
        this.fileName = fileName;
        this.city = city;
        this.age = age;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }
}
