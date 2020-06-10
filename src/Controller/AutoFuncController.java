package controller;
import View.*;
import View.UserInterface;
import model.*;


public class AutoFuncModel extends OpenController {
    UserInterface userInterface;
    model.AutoFuncModel model;

    public AutoFuncModel(UserInterface userInterface, model.AutoFuncModel model) {
        this.userInterface = userInterface;
        this.model = model;
    }
}
