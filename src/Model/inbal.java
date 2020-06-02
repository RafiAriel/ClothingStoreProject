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

   /* public String sellingItem() {
    }*/

    public boolean isItemsInStock(Purchase pur) {
        int i, j;
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = Data.getInstance().getItems();
            for (i = 0; i < pur.getItem().size(); i++) {
                for (j = 0; j < items.size(); j++) {
                    if (pur.getItem().get(i).getItemId() == items.get(j).getItemId())
                        if (items.get(j).getCurrentStock() <= 0)
                            return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}
