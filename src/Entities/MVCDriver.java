package Entities;

import Controller.myController;
import Model.myModel;
import Model.inbal;
import View.myCLI;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import Model.myModel;
import static java.lang.System.*;

public class MVCDriver {

    public static void main(String[] args) {
        myModel model = new myModel();
        myCLI view = new myCLI();
        myController co =  new myController (model , view);
        ArrayList<Item> items = new ArrayList<>();
        inbal inb = new inbal();

        Purchase p =  model.lastPurchase(3);
        Member m = new Member("rafi", "7/6/2002", 10,2000);
        Shirt s = new Shirt("blue", "adidas","men","shirt", 300, 10, 300, 600, 1, "wow");
        Shirt w = new Shirt("blue", "adidas","men","shirt", 300, 10, 300, 600, 2, "wow");

        items.add(s);
        items.add(w);
        Purchase a = new Purchase(m, items, 500,100);
        model.addClubMember(m);
        System.out.print('\n');
        System.out.println( inb.Selling(a));
    }

}






