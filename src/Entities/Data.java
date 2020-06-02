package Entities;
import java.sql.*;
import java.util.ArrayList;


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


    public static ArrayList<Purchase> getallPurchase() {
    ArrayList<Purchase> allpurchase = new ArrayList<>();
    Connection connection = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost/db?useSSL=false", "root", "6560634i");

        // Step 2:Create a statement using connection object
        Statement stmt = connection.createStatement();

        // Step 3: Execute the query or update query
        ResultSet rs = stmt.executeQuery("SELECT allpurchase.id as id, allpurchase.itemid as itemid, price, name FROM items, allpurchase, clubmembers WHERE items.itemid = allpurchase.itemid and allpurchase.id = clubmembers.id");
        {

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                int id = rs.getInt("id");
                int itemid = rs.getInt("itemid");
                allpurchase.add(new int[]{id, itemid});
            }
        }
    } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

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
        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
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

    public static ArrayList<Item> getItems() {
        Connection connection = null;
    
        ArrayList<Item> items = new ArrayList<>();
        try {


            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

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
                            Shirt shirts = new Shirt(color, brand, gender, price, size, currentStock, baseStock, id, shirtsType);
                            items.add(shirts);
                            break;
                        case "pant":
                            Pant pants = new Pant(color, brand, gender, price, size, currentStock, baseStock, id, pantsType);
                            items.add(pants);
                            break;
                        case "shoe":
                            Shoe shoes = new Shoe(color, brand, gender, price, size, currentStock, baseStock, id, drawstringColor);
                            items.add(shoes);
                            break;
                    }

            }

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
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

    public static ArrayList<Worker> getWorkers() {
        Connection connection = null;
        ArrayList<Worker> Workers = null;
        try {
            Workers = new ArrayList<>();

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            // Step 2:Create a statement using connection object
            Statement stmt = connection.createStatement();

            // Step 3: Execute the query or update query
            ResultSet rs = stmt.executeQuery("select * from workers");
            {

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    String name = rs.getString("name");
                    int id = rs.getInt("id");
                    String dateofbirth = rs.getString("dateofbirth");
                    double hourlysalary = rs.getDouble("hourlysalary");
                    double numHourMonth = rs.getDouble("numHourMonth");
                    String jobType = rs.getString("jobType");
                    String password = rs.getString("password");
                    Worker w = new Worker(name, dateofbirth, id ,hourlysalary, numHourMonth, jobType, password);
                    Workers.add(w);
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

        return Workers;
    }
}


