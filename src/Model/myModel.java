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

    public Purchase lastPurchase(int memId) {
        int i;
        ArrayList<Purchase> pur = new ArrayList<>();
        try {
            pur = Data.getInstance().getAllPurchase();
            for ( i = 0; i < pur.size()-1; i++)
                if (pur.get(i).getClubMember().equals(memId) && !pur.get(i+1).equals(memId))
                    return pur.get(i);
            if (pur.get(i).getClubMember().equals(memId))
                return pur.get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Purchase();
    }
}
