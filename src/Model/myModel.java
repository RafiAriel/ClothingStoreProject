package Model;
import Entities.*;
import Model.*;
import View.*;
import java.util.ArrayList;

public class myModel {

    public myModel() {
    }

    public Object searchItem(String nameOfItem, int size) {
        int i;
        ArrayList<Item> items = new ArrayList<>();
        try {
            items = Data.getInstance().getItems();
            for (i = 0; i < items.size(); i++)
                if (items.get(i).getClass().equals(nameOfItem) && items.get(i).getSize() == size && items.get(i).getBaseStock() - items.get(i).getCurrentStock() > 0) {
                    if ((nameOfItem.equals("Shirt")) || (nameOfItem.equals("shirt")))
                        return items.get(i);
                    if ((nameOfItem.equals("Pant")) || (nameOfItem.equals("pant")))
                    return items.get(i);
                    if ((nameOfItem.equals("Shoe")) || (nameOfItem.equals("shoe")))
                    return items.get(i);

                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
