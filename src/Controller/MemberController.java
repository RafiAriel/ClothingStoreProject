package controller;
import View.*;
import View.UserInterface;
import model.*;


public class MemberModel extends OpenController {
    UserInterface userInterface;
    model.MemberModel model;

    public MemberModel(UserInterface userInterface, model.MemberModel model) {
        this.userInterface = userInterface;
        this.model = model;
    }
}
