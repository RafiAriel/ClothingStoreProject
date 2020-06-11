package view;

import java.util.*;

public class UserInterface implements Runnable {
    private ViewFunc viewFunc;

    public UserInterface() {
        this.viewFunc = new ViewFunc();
    }

    public void start() {
        new Thread(this).run();
    }

    @Override
    public void run() {
        for(int i=1;i<=3;i++) {
            String str = viewFunc.login();
            if (str == "manager") {
                managerScreen();
                return;
            }
            if (str == "worker") {
                workerScreen();
                return;
            }
            if (str == "none")
                System.out.println("try again! **num "+i+" (at the third try the program will close!)");
        }
        System.out.println("you should remember your password for the next time...");
    }

    public void workerScreen()
    {
        Scanner s = new Scanner(System.in);
        while(true) {
        System.out.println("Hello Worker!!");
        System.out.println("what do you want to do?(choose number)");
        System.out.println("1. search product by Id and size");
        System.out.println("2. add club member");
        System.out.println("3. delete club member");
        System.out.println("4. check if the club member exists");
        System.out.println("5. selling");
        System.out.println("6. watch last purchase");
        System.out.println("7. watch my monthly salary");
        System.out.println("Any other number to exit");
        int temp=s.nextInt();
            switch (temp) {
                case 1:
                    viewFunc.searchItem();
                    break;
                case 2:
                    viewFunc.addClubMember();
                    break;
                case 3:
                    viewFunc.deleteClubMember();
                    break;
                case 4:
                    viewFunc.isMemberExists();
                    break;
                case 5:
                    viewFunc.selling();
                    break;
                case 6:
                    viewFunc.watchLastPurchase();
                    break;
                case 7:
                    viewFunc.watchMonthlySalary();
                    break;
                default:
                    System.out.println("***exit***)");
                    return;
            }
        }

    }

    public void managerScreen()
    {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Hello Manager!!");
            System.out.println("what do you want to do?(choose number)");
            System.out.println("1. search product by Id and size");
            System.out.println("2. add club member");
            System.out.println("3. delete club member");
            System.out.println("4. check if the club member exists");
            System.out.println("5. selling");
            System.out.println("6. watch last purchase");
            System.out.println("7. watch my monthly salary");
            System.out.println("8. watch average Selling Rate");
            System.out.println("9. find the best Selling Product");
            System.out.println("10. add new shoe/pants/shirt");
            System.out.println("11. Change Hourly Salary");
            System.out.println("12. add Worker");
            System.out.println("Any other number to exit");
            int temp=s.nextInt();
            switch (temp) {
                case 1:
                    viewFunc.searchItem();
                    break;
                case 2:
                    viewFunc.addClubMember();
                    break;
                case 3:
                    viewFunc.deleteClubMember();
                    break;
                case 4:
                    viewFunc.isMemberExists();
                    break;
                case 5:
                    viewFunc.selling();
                    break;
                case 6:
                    viewFunc.watchLastPurchase();
                    break;
                case 7:
                    viewFunc.watchMonthlySalary();
                    break;
                case 8:
                    viewFunc.averageSellingRate();
                    break;
                case 9:
                    viewFunc.bestSellingProduct();
                    break;
                case 10:
                    viewFunc.addItem();
                    break;
                case 11:
                    viewFunc.changeHourlySalary();
                    break;
                case 12:
                    viewFunc.addWorker();
                    break;
                default:
                    System.out.println("***exit***");
                    return;
            }
        }

    }
}