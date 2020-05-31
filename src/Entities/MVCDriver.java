package Entities;

import Controller.myController;
import Model.myModel;
import View.myCLI;

public class MVCDriver {

    public static void main(String[] args) {
        myModel model = new myModel();
        myCLI view = new myCLI();

        myController co =  new myController (model , view);
    }

}
