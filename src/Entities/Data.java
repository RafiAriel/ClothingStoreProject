package Entities;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Data {
    private static Data db;
    private static Object LockObject = new Object();
    private Data()
    {

    }
    //singleton design pattern
    public static Data getInstance()
    {
        if (db == null)
        {
            synchronized (LockObject) {
                if (db == null) {
                    db = new Data();
                }
            }
        }
        return db;
    }

public static ArrayList<int[]> allpurchase() {
    ArrayList<int[]> allpurchase = new ArrayList<>();
    Connection connection = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost/db?useSSL=false", "root", "ProjectClothingStore");

        // Step 2:Create a statement using connection object
        Statement stmt = connection.createStatement();

        // Step 3: Execute the query or update query
        ResultSet rs = stmt.executeQuery("select name, id, dateofbirth, pointgained, lastbuy from clubmembers");
        {

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                int id = rs.getInt("id");
                int itemid = rs.getInt("itemid");
                allpurchase.add(new int[]{id, itemid});
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    return allpurchase;
    // print example
    //  at row : 0, column : 0
    //   System.out.println("[id][itemid] : " + rows.get(0)[0]);
}


    public static ArrayList<Member> getClubMembers() {
        Connection connection = null;
        ArrayList<Member> ClubMembers = null;
        try {
            ClubMembers = new ArrayList<Member>();

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/db?useSSL=false", "root", "ProjectClothingStore");

            // Step 2:Create a statement using connection object
            Statement stmt = connection.createStatement();

            // Step 3: Execute the query or update query
            ResultSet rs = stmt.executeQuery("select name, id, dateofbirth, pointgained, lastbuy from clubmembers");
            {

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    String name = rs.getString("name");
                    int id = rs.getInt("id");
                    String dateofbirth = rs.getString("dateofbirth");
                    String pointgained = rs.getString("pointgained");
                    Integer pointgained1 = Integer.valueOf(pointgained);
                    Member m = new Member(name,dateofbirth, id, pointgained1);
                    ClubMembers.add(m);
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
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return ClubMembers;
    }
}


