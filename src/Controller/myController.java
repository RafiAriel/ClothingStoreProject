package Controller;
import Entities.*;
import Model.*;
import View.*;


import Model.myModel;
import View.myCLI;

public class myController
{
myModel model;
myCLI view;

    public myController(myModel model, myCLI view) {
        this.model = model;
        this.view = view;
    }
}


