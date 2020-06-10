package controller;
import View.*;
import View.UserInterface;
import model.*;


public class ManagerModel extends OpenController {
    UserInterface userInterface;
    model.ManagerModel model;

    public ManagerModel(UserInterface userInterface, model.ManagerModel model) {
        this.userInterface = userInterface;
        this.model = model;
    }
}
