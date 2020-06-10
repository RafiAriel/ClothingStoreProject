package controller;
import View.*;
import model.*;
import model.entities.Worker;

import java.sql.*;
import java.util.ArrayList;


public class ManagerController implements Controller {
    ViewInterface viewInterface;
    model.ManagerModel model;

    public ManagerController(ViewInterface viewInterface, ManagerModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }


    public String ChangeHourlySalary(int workerId, double newSalary) {
        return model.ChangeHourlySalary(workerId, newSalary);
    }

    public void addWorker(Worker w) {
        model.addWorker(w);
    }

    public String watchMonthlySalary(int workerId)
    {
        return model.watchMonthlySalary(workerId);
    }

    public boolean isExistsWorker(int workerId)
    {
        return model.isExistsWorker(workerId);
    }



}
