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

        Purchase p=  model.lastPurchase(2), a = new Purchase();
        Member m = p.getClubMember();
        System.out.print('\n');
        System.out.print( inb.updateMembersPoints(200,m));
    }

}






