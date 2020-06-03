package Model;
import Entities.*;
import Model.*;
import View.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        String strDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            Statement stmt = connection.createStatement();
            for(i=0;i<pur.getItem().size();i++) {
                String strInsert = "insert into allpurchase values (" + pur.getClubMember().getId() + "," + pur.getItem().get(i).getItemId()+",\""+strDate+"\","+pur.getShoppingRating()+")";
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
                            System.out.println("item number:"+pur.getItem().get(i).getItemId()+" is out of stock!!");
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
        int i, j;
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            Statement stmt = connection.createStatement();
            for(i=0;i<pur.getItem().size();i++) {
                String strUpdate = "update items set currentStock = currentStock -1 where itemid =" + pur.getItem().get(i).getItemId();
                int countUpdated = stmt.executeUpdate(strUpdate);
                ResultSet rs = stmt.executeQuery("select currentStock from items where itemid ="+pur.getItem().get(i).getItemId());
                rs.next();
                int currStock = rs.getInt("currentStock");
                if(currStock<0)
                {
                    System.out.println("item number:"+pur.getItem().get(i).getItemId()+" is out of stock!!");
                    for(j=i;j>=0;j--)
                    {
                        String strUpdate2 = "update items set currentStock = currentStock +1 where itemid =" + pur.getItem().get(j).getItemId();
                        int countUpdated2 = stmt.executeUpdate(strUpdate2);
                    }
                    return false;
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
        return true;
    }
}




