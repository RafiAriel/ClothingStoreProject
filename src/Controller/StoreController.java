package controller;
import View.*;
import View.UserInterface;
import model.*;


public class StoreModel extends OpenController {
    UserInterface view;
    model.StoreModel model;

    public StoreModel(UserInterface view, model.StoreModel model) {
        this.view = view;
        this.model = model;
    }
}
