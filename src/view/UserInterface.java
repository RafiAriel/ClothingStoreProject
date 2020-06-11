package view;

import controller.*;

public class UserInterface implements Runnable {
    private AutoFuncController autoFuncController;
    private ItemController itemController;
    private ManagerController managerController;
    private MemberController memberController;
    private PurchaseController purchaseController;
    private StoreController storeController;
    private WorkerController workerController;


    public UserInterface() {
        autoFuncController = new AutoFuncController();
        itemController = new ItemController();
        managerController = new ManagerController();
        memberController = new MemberController();
        purchaseController = new PurchaseController();
        storeController = new StoreController();
        workerController = new WorkerController();
    }

    public void start() {
        new Thread(this).run();
    }

    @Override
    public void run() {

        workerScreen();

    }

    public void workerScreen()
    {
        System.out.println("Welcome to the clothing store management system");
        System.out.print(itemController.bestSellingProduct());
    }
}