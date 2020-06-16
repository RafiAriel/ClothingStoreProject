package model;

import model.entities.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class AutoFuncModel {


    public ArrayList<String> checkCurrentStock() {
        int i;
        double presentOfCurrentStock = 0.2;
        ArrayList<String> itemsLow = new ArrayList<String>();
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            items = StoreModel.getInstance().getItems();
            for (i = 0; i < items.size(); i++) {
                if (((double) items.get(i).getCurrentStock() / items.get(i).getBaseStock()) < presentOfCurrentStock) {
                      String s=String.valueOf(items.get(i).getItemId());
                   itemsLow.add("System Message: stock is low. " + "item id:" + s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsLow;
    }

}
