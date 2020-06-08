package View;
import Entities.*;
import Model.*;
import View.*;
import Model.myModel;

import javax.swing.*;

public class myCLI {
    public myCLI() {
        BirthDayCLI();
      //  checkCurrentStockThread();
    }


    public void BirthDayCLI()
    {
        myModel M = new myModel();
        M.BirthdayPointAuto();
    }
    public void checkCurrentStockThread()
    {
        int i;
        try {
            Runnable runnable = new myModel();
            Thread t1 = new Thread(runnable);
            for (i = 144; i > 0; i--) { // 10 minutes loop, All day long
                t1.run();
                Thread.sleep(6000000); // 10 Minutes
            }
            t1.run();

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

    }
}