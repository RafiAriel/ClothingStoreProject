package controller;
import view.*;
import model.*;
import model.entities.Worker;

public class WorkerController {

  WorkerModel model;

    public WorkerController() {
        this.model = new WorkerModel();
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
