package Entities;

public class Person {
    protected String name;
    protected String dateOfBirth;
    protected int id;

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Person(String name, String dateOfBirth, int id) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
    }
}
