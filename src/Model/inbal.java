package Model;
import Entities.*;
import Model.*;
import View.*;
import java.sql.*;
import java.util.ArrayList;

public class inbal {
    public inbal() {

    }

    public double averageSeliingRate() {
        int i = 1;
        double sum = 0;
        ArrayList<Purchase> pur = new ArrayList<>();
        try {
            pur = Data.getInstance().getAllPurchase();
            for (i = 0; i < pur.size(); i++) {
                sum += pur.get(i).getShoppingRating();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sum /= i;
        return sum;
    }

    public String Selling(Purchase pur) {
        if(!updateStockMinus(pur))
            return "Purchase faild!";
        updateMembersPoints(pur.getPrice(), pur.getClubMember());
        int i;
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            Statement stmt = connection.createStatement();
            for(i=0;i<pur.getItem().size();i++) {
                String strInsert = "insert into allpurchase values (" + pur.getClubMember().getId() + "," + pur.getItem().get(i).getItemId()+",01/01/2001,"+pur.getShoppingRating()+")";
                int countUpdated = stmt.executeUpdate(strInsert);
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
        return "Purchase succeeded!";

    }

    public boolean isItemsInStock(Purchase pur) {
        int i, j;
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = Data.getInstance().getItems();
            for (i = 0; i < pur.getItem().size(); i++) {
                for (j = 0; j < items.size(); j++) {
                    if (pur.getItem().get(i).getItemId() == items.get(j).getItemId())
                        if (items.get(j).getCurrentStock() <= 0) {
                            System.out.println("item number:"+pur.getItem().get(i).getItemId()+"is out of stock!!");
                            return false;
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void updateMembersPoints(double price, Member m) {
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            Statement stmt = connection.createStatement();
            String strUpdate = "update clubmembers set pointgained = pointgained + 0.1*" + price + " where id =" + m.getId();
            int countUpdated = stmt.executeUpdate(strUpdate);
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

    public boolean updateStockMinus(Purchase pur) {
        if(!isItemsInStock(pur))
            return false;
        int i;
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            Statement stmt = connection.createStatement();
            for(i=0;i<pur.getItem().size();i++) {
                String strUpdate = "update items set currentStock = currentStock -1 where itemid =" + pur.getItem().get(i).getItemId();
                int countUpdated = stmt.executeUpdate(strUpdate);
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
        return true;
    }
}




