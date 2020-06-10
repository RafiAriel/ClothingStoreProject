package controller;
import View.*;
import model.*;
import model.entities.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class ItemController implements Controller {
    ViewInterface viewInterface;
    model.ItemModel model;

    public ItemController(ViewInterface viewInterface, ItemModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }

    public Item searchItem(int id, int size)
    {
        return model.searchItem(id, size);
    }
    public Item bestSellingProduct() {
        return model.bestSellingProduct();
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
