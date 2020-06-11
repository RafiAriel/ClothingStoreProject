package model;

import model.entities.Item;

import java.util.ArrayList;

public class AutoFuncModel implements Runnable {
    public void checkCurrentStock() {
        int i;

        double presentOfCurrentStock = 0.2;
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            items = StoreModel.getInstance().getItems();
            for (i = 0; i < items.size(); i++) {
                if (((double) items.get(i).getCurrentStock() / items.get(i).getBaseStock()) < presentOfCurrentStock) {
                    System.out.println("System Message: stock is low. " + "item id:" + items.get(i).getItemId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        checkCurrentStock();
    }


    public void checkCurrentStockThread() {
        int i;
        try {
            Runnable runnable = new AutoFuncModel();
            Thread t1 = new Thread(runnable);
            for (i = 144; i > 0; i--) { // 10 minutes loop, All day long
                t1.run();
                Thread.sleep(6000000); // 10 Minutes
            }

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

    }


}
