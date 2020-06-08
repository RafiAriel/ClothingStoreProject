package Model;

import Entities.*;

import java.sql.*;
import java.util.ArrayList;

public class inbal {
    public inbal() {
    }

    public String watchMonthlySalary(int workerId) {

        if(!isExistsWorker(workerId)) {return "You are not registered!\n";}

        int i;
        ArrayList<Worker> workers = new ArrayList<>();
        try {
            workers = Data.getInstance().getWorkers();
            for (i = 0; i < workers.size(); i++) {
                if (workerId == (workers.get(i).getId())) {
                    return "Your monthly salary is: "+ workers.get(i).getHourlySalary()*workers.get(i).getNumHourMonth()+"\n";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "You are not registered!\n";
    }

    public boolean isExistsWorker(int workerId) {
        int i;
        ArrayList<Worker> workers = new ArrayList<>();
        try {
            workers = Data.getInstance().getWorkers();
            for (i = 0; i < workers.size(); i++) {
                if (workerId == (workers.get(i).getId())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String ChangeHourlySalary(int workerId, double newSalary) {
        if(!isExistsWorker(workerId)) {return "worker are not registered!\n";}

        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "ProjectClothingStore");

            Statement stmt = connection.createStatement();
            String strUpdate = "update workers set hourlysalary = "  + newSalary + " where id =" + workerId;
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

    public void addWorker(Worker w) {
        if (isExistsWorker(w.getId()) == false) {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "ProjectClothingStore");
                String INSERT_USERS_SQL = "INSERT INTO workers" + "  (name, id, dateofbirth, hourlysalary, numHourMonth, jobType, password) VALUES " +
                        " (?, ?, ?, ?, ?, ?, ?);";

                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
                connection.setAutoCommit(false);
                preparedStatement.setString(1, w.getName());
                preparedStatement.setInt(2, w.getId());
                preparedStatement.setString(3, w.getDateOfBirth());
                preparedStatement.setDouble(4, w.getHourlySalary());
                preparedStatement.setDouble(5, w.getNumHourMonth());
                preparedStatement.setString(6, w.getJobType());
                preparedStatement.setString(7, w.getPassword());
                preparedStatement.addBatch();
                int[] updateCounts = preparedStatement.executeBatch();
                connection.commit();
                connection.setAutoCommit(true);
            } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}





