package Entities;

import Controller.myController;
import Model.myModel;
import View.myCLI;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import Model.myModel;
import static java.lang.System.*;

public class MVCDriver {

    public static void main(String[] args)  {
        myModel model = new myModel();
        myCLI view = new myCLI();
        myController co =  new myController (model , view);
        ArrayList<Item> items = new ArrayList<>();
        items = Data.getInstance().getItems();
        for(int i=0;i<items.size();i++) {
            System.out.print(items.get(i).getColor());
            System.out.print(' ');
            System.out.println(items.get(i).getPrice());
        }

        System.out.print( model.searchItem("Shoe", 40));
    }

}






