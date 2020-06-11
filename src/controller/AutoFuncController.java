package controller;
import view.*;
import model.*;


public class AutoFuncController {
    ViewInterface viewInterface;
    AutoFuncModel model;

    public AutoFuncController(ViewInterface viewInterface, AutoFuncModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }

    public AutoFuncController() {

    }


    public void checkCurrentStockThread()
    {
        model.checkCurrentStockThread();
    }

}
