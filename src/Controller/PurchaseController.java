package controller;
import View.*;
import View.UserInterface;
import model.*;


public class PurchaseModel extends OpenController {
    UserInterface userInterface;
    model.PurchaseModel model;

    public PurchaseModel(UserInterface userInterface, model.PurchaseModel model) {
        this.userInterface = userInterface;
        this.model = model;
    }
}
