package Entities;
import java.sql.*;
import java.io.*;
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

    public static ArrayList<Item> getItem() {
        Connection connection = null;
        ArrayList<Item> items = null;
        try {
            items = new ArrayList<Item>();

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/db?useSSL=false", "root", "ProjectClothingStore");

            // Step 2:Create a statement using connection object
            Statement stmt = connection.createStatement();

            // Step 3: Execute the query or update query
            ResultSet rs = stmt.executeQuery("select * from items");

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                    int id = rs.getInt("itemid");
                    String color = rs.getString("color");
                    double price = rs.getDouble("price");
                    String type = rs.getString("type");
                    int size = rs.getInt("size");
                    String brand = rs.getString("brand");
                    String gender = rs.getString("gender");
                    int baseStock = rs.getInt("baseStock");
                    int currentStock = rs.getInt("currentStock");
                    String drawstringColor = rs.getString("drawstringcolor");
                    String pantsType = rs.getString("pantstype");
                    String shirtsType = rs.getString("shirtstype");
                    switch(type){
                        case "shirt":
                            Item itemp1 = new Shirts(color, brand, gender, price, size, currentStock, baseStock, id, shirtsType);
                            items.add(itemp1);
                            break;
                        case "pant":
                            Item itemp2 = new Pants(color, brand, gender, price, size, currentStock, baseStock, id, pantsType);
                            items.add(itemp2);
                            break;
                        case "shoe":
                            Item itemp3 = new Shoes(color, brand, gender, price, size, currentStock, baseStock, id, drawstringColor);
                            items.add(itemp3);
                            break;
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

        return items;
    }
}


