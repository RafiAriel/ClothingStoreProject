package controller;
import view.*;
import model.*;
import model.entities.*;


public class ItemController {

    protected ItemModel model;

    public ItemController() {
        this.model = new ItemModel();
    }

    public Item searchItem(int id, int size)
    {
       return model.searchItem(id,size);
    }

    public Item bestSellingProduct() { return model.bestSellingProduct(); }

    public boolean isAllItemsExist(Purchase pur) {
        return model.isAllItemsExist(pur);
    }

    public boolean isItemExists(int id, int size){return model.isItemExists(id,size);}

    public void addPants(Pants pants) {
        model.addPants(pants);
    }

    public void addShoe(Shoe shoe) {
        model.addShoe(shoe);
    }

    public void addShirt(Shirt shirt) {
        model.addShirt(shirt);
    }

}
