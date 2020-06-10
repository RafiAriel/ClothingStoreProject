package model;

import model.entities.Item;
import model.entities.Purchase;
import model.entities.Shirt;

import java.util.ArrayList;

public class ItemModel {

    public Item searchItem(int id, int size) {
        int i;
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = StoreModel.getInstance().getItems();
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

    public Item bestSellingProduct() {
        int i, max = 0;
        Item temp = new Shirt();
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = StoreModel.getInstance().getItems();
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

    public boolean isItemsInStock(Purchase pur) {
        int i, j;
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = StoreModel.getInstance().getItems();
            for (i = 0; i < pur.getItem().size(); i++) {
                for (j = 0; j < items.size(); j++) {
                    if (pur.getItem().get(i).getItemId() == items.get(j).getItemId())
                        if (items.get(j).getCurrentStock() <= 0) {
                            System.out.println("item number:"+pur.getItem().get(i).getItemId()+" is out of stock!!");
                            return false;
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
