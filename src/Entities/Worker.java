package Entities;

public class Worker extends Person{
    private double hourlySalary, numHourMonth;
    private String jobType, password;

    public double getHourlySalary() {
        return hourlySalary;
    }
    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
    public double getNumHourMonth() {
        return numHourMonth;
    }
    public void setNumHourMonth(double numHourMonth) {
        this.numHourMonth = numHourMonth;
    }
    public String getJobType() {
        return jobType;
    }
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Worker(String name, String dateOfBirth, int id, double hourlySalary, double numHourMonth, String jobType, String password) {
        super(name, dateOfBirth, id);
        this.hourlySalary = hourlySalary;
        this.numHourMonth = numHourMonth;
        this.jobType = jobType;
        this.password = password;
    }
    public Worker()
    {}

}
