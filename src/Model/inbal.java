package Model;
import Entities.*;
import Model.*;
import View.*;

import java.sql.*;
import java.util.ArrayList;

public class inbal {
    public inbal() { }

    public double averageSeliingRate() {
        int i=1;
        double sum=0;
        ArrayList<Purchase> pur = new ArrayList<>();
        try {
            pur = Data.getInstance().getAllPurchase();
            for (i = 0; i < pur.size(); i++) {
                sum+=pur.get(i).getShoppingRating();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sum/=i;
        return sum;
    }
}
