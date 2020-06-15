package controller;
import view.*;
import model.*;
import model.entities.Worker;


public class ManagerController extends WorkerController{

    protected ManagerModel model;


    public ManagerController() {
        this.model = new ManagerModel();
    }

    public boolean changeHourlySalary(int workerId, int newSalary) {
        return model.changeHourlySalary(workerId, newSalary);
    }
}
