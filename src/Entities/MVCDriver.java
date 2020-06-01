package Entities;

import Controller.myController;
import Model.myModel;
import View.myCLI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.*;

public class MVCDriver {

    public static void main(String[] args) throws SQLException, IllegalAccessException {
        myModel model = new myModel();
        myCLI view = new myCLI();
        myController co =  new myController (model , view);



    }
    }


