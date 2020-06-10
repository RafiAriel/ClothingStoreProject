package controller;
import View.*;
import model.*;


public class AutoFuncController implements Controller {
    ViewInterface viewInterface;
    AutoFuncModel model;

    public AutoFuncController(ViewInterface viewInterface, AutoFuncModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }
    public void run()
    {
        model.checkCurrentStockThread();
    }
}
