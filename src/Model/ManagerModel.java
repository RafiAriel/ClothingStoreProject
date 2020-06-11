package model;

import java.sql.*;

public class ManagerModel extends  WorkerModel {

    public String ChangeHourlySalary(int workerId, double newSalary) {
        if (!isExistsWorker(workerId)) {
            return "worker are not registered!\n";
        }

        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "ProjectClothingStore");

            Statement stmt = connection.createStatement();
            String strUpdate = "update workers set hourlysalary = " + newSalary + " where id =" + workerId;
            int countUpdated = stmt.executeUpdate(strUpdate);
            return "update successfully passed!";
        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "update failed!";
    }


}
