package Model;

import Entities.*;
import View.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import java.sql.*;
import java.util.ArrayList;

public class myModel implements Runnable {

    public myModel() {
    }

    public Item searchItem(int id, int size) {
        int i;
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = Data.getInstance().getItems();
            for (i = 0; i < items.size(); i++) {
                if ((Integer.valueOf(id) == (items.get(i).getItemId()) && items.get(i).getSize() == size && items.get(i).getBaseStock() - items.get(i).getCurrentStock() > 0)) {
                    return items.get(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Item NONE = new Shirt();
        return NONE;

    }

    public void addClubMember(Member m) {
        if (isExistsClubMember(m.getId()) == false) {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");
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

    public boolean isExistsClubMember(int id) {
        int i;
        ArrayList<Member> members = new ArrayList<>();
        try {
            members = Data.getInstance().getClubMembers();
            for (i = 0; i < members.size(); i++) {
                if (Integer.valueOf(id) == (members.get(i).getId())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public void deleteClubMember(int id) {
        Connection connection = null;
        String idNumber = String.valueOf(id);
        String DELETE_USERS_SQL = "delete from clubmembers where id = " + idNumber + ";";
        if (isExistsClubMember(id) == true) {

            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "ProjectClothingStore");
                Statement statement = connection.createStatement();
                statement.executeUpdate(DELETE_USERS_SQL);
                System.out.println("Deletion was successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Unable to delete, no such user in the system");
        }
    }

    public double averageSellingRate() {
        int i = 1;
        double sum = 0;
        ArrayList<Purchase> pur = new ArrayList<>();
        try {
            pur = Data.getInstance().getAllPurchase();
            for (i = 0; i < pur.size(); i++) {
                sum += pur.get(i).getShoppingRating();
            }
            sum /= i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;

    }

    public String Selling(Purchase pur) {
        if (!updateStockMinus(pur))
            return "Purchase faild!";
        double newprice = PointDiscount(pur.getPrice(),pur.getClubMember());
        updateMembersPoints(newprice, pur.getClubMember());
        int i;
        String strDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            Statement stmt = connection.createStatement();
            for (i = 0; i < pur.getItems().size(); i++) {
                String strInsert = "insert into allpurchase values (" + pur.getClubMember().getId() + "," + pur.getItems().get(i).getItemId() + ",\"" + strDate + "\"," + pur.getShoppingRating() + ")";
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
            for (i = 0; i < pur.getItems().size(); i++) {
                for (j = 0; j < items.size(); j++) {
                    if (pur.getItems().get(i).getItemId() == items.get(j).getItemId())
                        if (items.get(j).getCurrentStock() <= 0) {
                            System.out.println("item number:" + pur.getItems().get(i).getItemId() + " is out of stock!!");
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
            ArrayList<Item> purItems = pur.getItems();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            Statement stmt = connection.createStatement();

            for (i = 0; i < purItems.size(); i++) {
                String strUpdate = "update items set currentStock = currentStock -1 where itemid =" + purItems.get(i).getItemId();
                int countUpdated = stmt.executeUpdate(strUpdate);
                ResultSet rs = stmt.executeQuery("select currentStock from items where itemid =" + purItems.get(i).getItemId());
                rs.next();
                int currStock = rs.getInt("currentStock");
                if (currStock < 0) {
                    System.out.println("item number:" + purItems.get(i).getItemId() + " is out of stock!!");
                    for (j = i; j >= 0; j--) {
                        String strUpdate2 = "update items set currentStock = currentStock +1 where itemid =" + purItems.get(j).getItemId();
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

    public void checkCurrentStock() {
        int i;
        System.out.println("checkCurrentStock");
        double presentOfCurrentStock = 0.2;
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Item> itemsEndingSoon = new ArrayList<Item>();
        try {
            items = Data.getInstance().getItems();
            for (i = 0; i < items.size(); i++) {
                if (((double)items.get(i).getCurrentStock() / items.get(i).getBaseStock()) < presentOfCurrentStock) {
                    System.out.println("System Message: stock is low: " + "item id:" + items.get(i).getItemId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int Login(int id, String password) {
        int i;
        ArrayList<Worker> Workers = null;
        try {
            Workers = new ArrayList<>();
            Workers = Data.getInstance().getWorkers();
            for (i = 0; i < Workers.size(); i++) {
                if ((Integer.valueOf(id) == Workers.get(i).getId() && Workers.get(i).getPassword().equals(password))) {
                    return Workers.get(i).getId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }

    public boolean isManager(int id, String password) {
        try {
            int i = Login(id, password);
            if (i == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isWorker(int id, String password) {
        try {
            int i = Login(id, password);
            if (i != -1 && i != 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void run() {

        checkCurrentStock();
    }


    public void BirthdayPointAuto() {
        int i;
        Connection connection = null;
        ArrayList<Member> ClubMembers = null;
        try {
            ClubMembers = new ArrayList<Member>();
            ClubMembers = Data.getInstance().getClubMembers();
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            for (i = 0; i < ClubMembers.size(); i++) {
                String[] dateClubMembers = ClubMembers.get(i).getDateOfBirth().split("/");
                int dayMember = Integer.parseInt(dateClubMembers[0]);
                int monthMember = Integer.parseInt(dateClubMembers[1]);
                if (Integer.valueOf(month) == Integer.valueOf(monthMember) && Integer.valueOf(day) == Integer.valueOf(dayMember))
                {
                updateMembersPoints(250, ClubMembers.get(i));
                System.out.println("System message: 250 credits added to club member" + ClubMembers.get(i).getName() + ", id: " + ClubMembers.get(i).getId());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private double PointDiscount(double price, Member clubmember) {
        int point = clubmember.getPointsGained();
        if (price >= point) {
            clubmember.setPointsGained(0);
            price -= point;
            return price;
        } else {
            clubmember.setPointsGained((int) (point - price));
            return 0;
        }

    }

}