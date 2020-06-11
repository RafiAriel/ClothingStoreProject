package controller;
import view.*;
import model.*;
import model.entities.*;

import java.util.ArrayList;


public class StoreController {
    ViewInterface viewInterface;
    model.StoreModel model;

    public StoreController(ViewInterface viewInterface, StoreModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }

    public StoreController() {
        
    }


    public static StoreModel getInstance()
    {
        return StoreModel.getInstance();
    }
    public static ArrayList<Purchase> getAllPurchase()
    {
        return StoreModel.getAllPurchase();
    }

    public static ArrayList<Member> getClubMembers()
    {
        return StoreModel.getClubMembers();
    }

    public static ArrayList<Item> getItems()
    {
        return StoreModel.getItems();
    }

    public static ArrayList<Worker> getWorkers()
    {
        return StoreModel.getWorkers();
    }

    public int averageSellingRate()
    {
        return model.averageSellingRate();
    }

    public int Login(int id, String password)
    {
        return model.Login(id, password);
    }


    public boolean isManager(int id, String password)
    {
        String idString =String.valueOf(id);
        if (idString == null || idString.trim().equals("") || password == null || password.trim().equals("")) {
            throw new IllegalArgumentException("Username or password must not be null");
        }
        String session = model.isManager(id, password);
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }

        return false;
    }

    public boolean isWorker(int id, String password)
    {
        String idString =String.valueOf(id);
        if (idString == null || idString.trim().equals("") || password == null || password.trim().equals("")) {
            throw new IllegalArgumentException("Username or password must not be null");
        }
        String session = model.isWorker(id, password);
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }

        return false;
    }




}
