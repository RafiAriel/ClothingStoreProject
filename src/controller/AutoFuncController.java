package controller;
import view.*;
import model.*;


public class AutoFuncController {

    protected AutoFuncModel model;

    public AutoFuncController() {
        this.model = new AutoFuncModel();
    }

    public void checkCurrentStockThread()
    {
        model.checkCurrentStockThread();
    }

}
