package model;

import model.entities.Purchase;
import model.entities.Worker;

import java.util.ArrayList;
import java.util.UUID;

public class GeneralOpModel {
    public GeneralOpModel() {
    }

    public int averageSellingRate() {
        int i=1;
        int sum=0;
        ArrayList<Purchase> pur = new ArrayList<>();
        try {
            pur = StoreModel.getInstance().getAllPurchase();
            for (i = 0; i < pur.size(); i++) {
                sum += pur.get(i).getShoppingRating();
            }
            sum/=i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;

    }

    public int Login(int id, String password) {
        int i;
        ArrayList<Worker> Workers = null;
        try {
            Workers = new ArrayList<>();
            Workers = StoreModel.getInstance().getWorkers();
            for (i = 0; i < Workers.size(); i++) {
                if((Integer.valueOf(id) == Workers.get(i).getId() && Workers.get(i).getPassword().equals(password)))
                {
                    return Workers.get(i).getId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }

    public String isManager(int id, String password) {
        int i;
        try {
            i = Login(id, password);
            if(i == 1)
            {
                return UUID.randomUUID().toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String isWorker(int id, String password) {
        try {
            int i = Login(id, password);
            if(i != -1 && i != 1)
            {
                return UUID.randomUUID().toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
