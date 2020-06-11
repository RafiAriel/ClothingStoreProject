package View;

import controller.*;
import model.MemberModel;

import java.util.Scanner;

public class UserInterface implements ViewInterface, Runnable {
    private AutoFuncController autoFuncController;
    private ItemController itemController;
    private ManagerController managerController;
    private MemberController memberController;
    private OpenController openController;
    private PurchaseController purchaseController;
    private StoreController storeController;
    private WorkerController workerController;



    public UserInterface() {

        autoFuncController = new AutoFuncController();
        itemController = new ItemController();
        managerController = new ManagerController();
        memberController = new MemberController();
        openController = new OpenController();
        purchaseController = new PurchaseController();
        storeController = new StoreController();
        workerController = new WorkerController();



    }



    @Override
    public void start() {
        new Thread(this).run();
    }



    public void run() {

        System.out.println("Welcome to the clothing store management system");
        memberController.birthdayPointAuto();





    }
}