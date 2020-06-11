package controller;
import view.*;
import model.*;
import model.entities.Worker;

public class WorkerController {
    ViewInterface viewInterface;
  model.WorkerModel model;

    public WorkerController(ViewInterface viewInterface, WorkerModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }

    public WorkerController() {

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
