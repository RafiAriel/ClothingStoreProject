package controller;
import View.*;
import View.UserInterface;
import model.*;

public class WorkerModel extends OpenController {
  UserInterface userInterface;
  model.WorkerModel model;

    public WorkerModel(UserInterface userInterface, model.WorkerModel model) {
        this.userInterface = userInterface;
        this.model = model;
    }
}
