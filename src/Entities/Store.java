package Entities;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Store {
        private static Store db;
        private static Object LockObject = new Object();
        private Store()
        {

        }
        //singleton design pattern
        public static Store getInstance()
        {
            if (db == null)
            {
                synchronized (LockObject) {
                    if (db == null) {
                        db = new Store();
                    }
                }
            }
            return db;
        }

    public static void getClubMembers() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/db?useSSL=false", "root", "ProjectClothingStore");

            // Step 2:Create a statement using connection object
            Statement stmt = connection.createStatement();

            // Step 3: Execute the query or update query
            ResultSet rs = stmt.executeQuery("select name, id, dateofbirth, pointgained, lastbuy from clubmembers"); {

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    String name = rs.getString("name");
                    int id = rs.getInt("id");
                    String dateofbirth = rs.getString("dateofbirth");
                    String pointgained = rs.getString("pointgained");
                    String lastbuy = rs.getString("lastbuy");
                    System.out.println(name + "," + id + "," + dateofbirth + "," + "," + pointgained + "," + lastbuy );
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}


