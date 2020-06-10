package controller;
import View.*;
import model.*;
import model.entities.*;

import java.sql.*;
import java.util.ArrayList;


public class StoreController implements Controller {
    ViewInterface viewInterface;
    model.StoreModel model;

    public StoreController(ViewInterface viewInterface, StoreModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
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
        return model.isManager(id, password);
    }


    public boolean isWorker(int id, String password)
    {
        return model.isWorker(id, password);
    }


}
