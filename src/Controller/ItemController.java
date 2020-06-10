package controller;
import View.*;
import View.UserInterface;
import model.*;


public class ItemModel extends OpenController {
    UserInterface userInterface;
    model.ItemModel model;

    public ItemModel(UserInterface userInterface, model.ItemModel model) {
        this.userInterface = userInterface;
        this.model = model;
    }
}
