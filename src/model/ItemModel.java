package model;

import model.entities.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {

    public Item searchItem(int id, int size) { //if exist and in stock
        int i;
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = StoreModel.getInstance().getItems();
            for (i = 0; i < items.size(); i++) {
                if (id == items.get(i).getItemId() && items.get(i).getSize() == size && (items.get(i).getBaseStock() - items.get(i).getCurrentStock()) > 0) {
                    return items.get(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Item NONE = new Shirt();
        return NONE;
    }

    public boolean isItemExists(int id, int size) {
        int i;
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = StoreModel.getInstance().getItems();
            for (i = 0; i < items.size(); i++) {
                if (id == items.get(i).getItemId() && items.get(i).getSize() == size) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Item bestSellingProduct() {
        int i, max = 0;
        Item temp = new Shirt();
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = StoreModel.getInstance().getItems();
            for (i = 0; i < items.size(); i++) {
                if (items.get(i).getBaseStock() - items.get(i).getCurrentStock() > max) {
                    max = items.get(i).getBaseStock() - items.get(i).getCurrentStock();
                    temp = items.get(i);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

   public boolean isAllItemsExist(Purchase pur) {
        int i;
        try {
            for (i = 0; i < pur.getItem().size(); i++) {
                if(!isItemExists(pur.getItem().get(i).getItemId(),pur.getItem().get(i).getSize())) {
                    System.out.println("item:" +pur.getItem().get(i).getItemId()+" is not exist!");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void addPants(Pants pants) {
        if (pants.getItemId() < 0 || pants.getSize() < 0)
        {
            throw new IllegalArgumentException("id or size must not be negative");
        }
        if (isItemExists(pants.getItemId(), pants.getSize()))
        {
            throw new IllegalArgumentException("id and size exist");
        }
        if (!isItemExists(pants.getItemId(), pants.getSize())) {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "ProjectClothingStore");
                String INSERT_USERS_SQL = "INSERT INTO items" + "  (itemid, color, price, type, size, brand, gender, drawstringcolor, pantstype, shirtstype, basestock, currentStock) VALUES " +
                        " (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?);";

                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
                connection.setAutoCommit(false);
                preparedStatement.setInt(1, pants.getItemId());
                preparedStatement.setString(2, pants.getColor());
                preparedStatement.setInt(3, pants.getPrice());
                preparedStatement.setString(4, pants.getType());
                preparedStatement.setInt(5, pants.getSize());
                preparedStatement.setString(6, pants.getBrand());
                preparedStatement.setString(7, pants.getGender());
                preparedStatement.setString(8, "null");
                preparedStatement.setString(9, pants.getPantsType());
                preparedStatement.setString(10, "null");
                preparedStatement.setInt(11, pants.getBaseStock());
                preparedStatement.setInt(12, pants.getCurrentStock());
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
            System.out.println("action succeeded!");
        } else {
            System.out.println("the item is already exists!");
        }

    }

    public void addShoe(Shoe shoe) {
        if (shoe.getItemId() < 0 || shoe.getSize() < 0)
        {
            throw new IllegalArgumentException("id or size must not be negative");
        }
        if (isItemExists(shoe.getItemId(), shoe.getSize()))
        {
            throw new IllegalArgumentException("id and size exist");
        }

        if (!isItemExists(shoe.getItemId(), shoe.getSize())) {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "ProjectClothingStore");
                String INSERT_USERS_SQL = "INSERT INTO items" + "  (itemid, color, price, type, size, brand, gender, drawstringcolor, pantstype, shirtstype, basestock, currentStock) VALUES " +
                        " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
                connection.setAutoCommit(false);
                preparedStatement.setInt(1, shoe.getItemId());
                preparedStatement.setString(2, shoe.getColor());
                preparedStatement.setInt(3, shoe.getPrice());
                preparedStatement.setString(4, shoe.getType());
                preparedStatement.setInt(5, shoe.getSize());
                preparedStatement.setString(6, shoe.getBrand());
                preparedStatement.setString(7, shoe.getGender());
                preparedStatement.setString(8, shoe.getDrawstringColor());
                preparedStatement.setString(9, "null");
                preparedStatement.setString(10, "null");
                preparedStatement.setInt(11, shoe.getBaseStock());
                preparedStatement.setInt(12, shoe.getCurrentStock());
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
                System.out.println("action succeeded!");
            }
        } else {
            System.out.println("the item is already exists!");
        }
    }

    public void addShirt(Shirt shirt) {
        if (shirt.getItemId() < 0 || shirt.getSize() < 0)
        {
            throw new IllegalArgumentException("id or size must not be negative");
        }
        if (isItemExists(shirt.getItemId(), shirt.getSize()))
        {
            throw new IllegalArgumentException("id and size exist");
        }
        if (!isItemExists(shirt.getItemId(), shirt.getSize())) {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "ProjectClothingStore");
                String INSERT_USERS_SQL = "INSERT INTO items" + "  (itemid, color, price, type, size, brand, gender, drawstringcolor, pantstype, shirtstype, basestock, currentStock) VALUES " +
                        " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
                connection.setAutoCommit(false);
                preparedStatement.setInt(1, shirt.getItemId());
                preparedStatement.setString(2, shirt.getColor());
                preparedStatement.setInt(3, shirt.getPrice());
                preparedStatement.setString(4, shirt.getType());
                preparedStatement.setInt(5, shirt.getSize());
                preparedStatement.setString(6, shirt.getBrand());
                preparedStatement.setString(7, shirt.getGender());
                preparedStatement.setString(8, "null");
                preparedStatement.setString(9, "null");
                preparedStatement.setString(10, shirt.getShirtType());
                preparedStatement.setInt(11, shirt.getBaseStock());
                preparedStatement.setInt(12, shirt.getCurrentStock());

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
             System.out.println("action succeeded!");
            }
        } else {
            System.out.println("the item is already exists!");
        }
    }

}

