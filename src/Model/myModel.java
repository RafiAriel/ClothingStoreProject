package Model;
import Entities.*;
import Model.*;
import View.*;

import java.sql.*;
import java.util.ArrayList;

public class myModel {

    public myModel() {
    }

    public Item searchItem(String nameOfItem, int size) {
        int i;
        ArrayList<Item> items = new ArrayList<>();
        items = Data.getInstance().getItems();
        for (i = 0; i < items.size(); i++) {
            if (((nameOfItem.equals(items.get(i).getType())) && items.get(i).getSize() == size && items.get(i).getBaseStock() - items.get(i).getCurrentStock() > 0)) {
                return items.get(i);
            }
        }
        Item NONE = new Shirt();
        return NONE;

    }

    public void addClubMember(Member m) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "ProjectClothingStore");
            String INSERT_USERS_SQL = "INSERT INTO clubmembers" + "  (name, id, dateofbirth, pointgained) VALUES " +
                    " (?, ?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, m.getName());
            preparedStatement.setInt(2, m.getId());
            preparedStatement.setString(3, m.getDateOfBirth());
            preparedStatement.setInt(4, m.getPointsGained());
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

    public Purchase lastPurchase(int memId) {
        int i;
        ArrayList<Purchase> pur = new ArrayList<>();
        try {
            pur = Data.getInstance().getAllPurchase();
            for (i = 0; i < pur.size() - 1; i++)
                if (pur.get(i).getClubMember().getId() == memId && pur.get(i + 1).getClubMember().getId() != memId)
                    return pur.get(i);
            if (pur.get(i).getClubMember().getId() == memId)
                return pur.get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Purchase p = new Purchase();
        return p;
    }

    public Item bestSellingProduct() {
        int i, max = 0;
        Item temp = new Shirt();
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = Data.getInstance().getItems();
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


}
