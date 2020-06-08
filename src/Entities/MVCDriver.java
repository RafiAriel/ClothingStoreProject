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

        Member m = new Member("alon","5/5/5",7979,7000);
        model.addClubMember(m);
        Item item = model.searchItem(1, 40);
        items.add(item);
        Purchase p = new Purchase(m,items, 30);
        System.out.println(model.Selling(p));

    }

}






