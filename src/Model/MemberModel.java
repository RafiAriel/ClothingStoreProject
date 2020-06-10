package model;

import model.entities.Member;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class MemberModel {
    public MemberModel() {
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

    public void deleteClubMember(int id) {
        Connection connection = null;
        String idNumber = String.valueOf(id);
        String DELETE_USERS_SQL = "delete from clubmembers where id = " + idNumber + ";";
        if (isExistsClubMember(id) == true) {

            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");
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

    public boolean isExistsClubMember(int id) {
        int i;
        ArrayList<Member> members = new ArrayList<>();
        try {
            members = StoreModel.getInstance().getClubMembers();
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

    public void BirthdayPointAuto() {
        int i;
        Connection connection = null;
        ArrayList<Member> ClubMembers = null;
        try {
            ClubMembers = new ArrayList<Member>();
            ClubMembers = StoreModel.getInstance().getClubMembers();
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = localDate.getMonthValue();
            int day   = localDate.getDayOfMonth();
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

    public void updateMembersPoints(double price, Member m) {
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "6560634i");

            Statement stmt = connection.createStatement();
            String strUpdate = "update clubmembers set pointgained = pointgained +" + price + " where id =" + m.getId();
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
}
