package Entities;

import Controller.myController;
import Model.*;
import View.myCLI;

import java.util.ArrayList;

public class MVCDriver {

    public static void main(String[] args) {
        myModel model = new myModel();
        myCLI view = new myCLI();
        myController co =  new myController (model , view);
        inbal inb = new inbal();

        ArrayList<Item> items = new ArrayList<>();




    }

}






