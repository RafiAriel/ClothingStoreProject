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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class MVCDriver {

    public static void main(String[] args) {
        myModel model = new myModel();
        myCLI view = new myCLI();
        myController co =  new myController (model , view);
        ArrayList<Item> items = new ArrayList<>();
        inbal inb = new inbal();
        System.out.print(model.averageSellingRate());
        Purchase p =  model.lastPurchase(3);
        Member m = new Member("rafi", "7/6/2002", 10,2000);
        Shirt s = new Shirt("blue", "adidas","men","shirt", 300, 10, 300, 600, 4, "wow");
        Shirt w = new Shirt("blue", "adidas","men","shirt", 300, 10, 300, 600, 3, "wow");

        items.add(s);

        Purchase a = new Purchase(m, items, 500,100);
        model.addClubMember(m);
        System.out.println( model.Selling(a));
    }

}






