package Entities;

import Controller.myController;
import Model.myModel;
import View.myCLI;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import Model.myModel;


public class MVCDriver {

    public static void main(String[] args) {
        myModel model = new myModel();
        myCLI view = new myCLI();
        myController co = new myController(model, view);


    }
}






