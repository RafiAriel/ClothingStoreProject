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
        //ArrayList<Purchase> all = new ArrayList<>();

        Purchase p=  model.lastPurchase(1);

        for(int i=0;i<p.getItem().size();i++) {
            System.out.print(p.getItem().get(i).getBrand());
            System.out.print(' ');
            //    System.out.println(items.get(i).getPrice());
        }
       /* all = Data.getInstance().getAllPurchase();
        for(int i=0;i<all.size();i++) {
            System.out.print(all.get(i).getPrice());
            System.out.print(' ');
        //    System.out.println(items.get(i).getPrice());
        }*/

    //   System.out.print( model.searchItem("Shoe", 40));
    }

}






