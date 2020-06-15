package model;

import model.entities.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class AutoFuncModel {


    public void checkCurrentStock() {
        int i;
        double presentOfCurrentStock = 0.2;
     //   ArrayList<Item> itemsLow = new ArrayList<Item>();
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            items = StoreModel.getInstance().getItems();
            for (i = 0; i < items.size(); i++) {
                if (((double) items.get(i).getCurrentStock() / items.get(i).getBaseStock()) < presentOfCurrentStock) {
            //        items.add(items.get(i));
                    System.out.println("System Message: stock is low. " + "item id:" + items.get(i).getItemId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return itemsLow;
    }

    public void runCheckCurrentStock() {
       TimerTask task = new TimerTask() {
           @Override
           public void run() {
               checkCurrentStock();
           }
       };

       Timer timer = new Timer();
       timer.schedule(task, new Date(), 300000);

   }
}
