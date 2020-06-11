package controller;
import view.*;
import model.*;
import model.entities.*;


public class ItemController {

    protected model.ItemModel model;

    public ItemController() {
        this.model = new ItemModel();
    }

    public Item searchItem(int id, int size)
    {
        return model.searchItem(id, size);
    }
    public int bestSellingProduct() {
        int x = model.bestSellingProduct().getItemId();
        return x;
    }
    public boolean isItemsInStock(Purchase pur)
    {
        return model.isItemsInStock(pur);
    }
    public void addPants(Pants pants)
    {
        model.addPants(pants);
    }
    public void addShoe(Shoe shoe)
    {
        model.addShoe(shoe);
    }
    public void addShirt(Shirt shirt)
    {
        model.addShirt(shirt);
    }

}
