package controller;
import model.entities.Item;
import view.*;
import model.*;

import java.util.ArrayList;


public class AutoFuncController {

    protected AutoFuncModel model;

    public AutoFuncController() {
        this.model = new AutoFuncModel();
    }

    public void checkCurrentStock()
    {
         model.runCheckCurrentStock();
    }

}
