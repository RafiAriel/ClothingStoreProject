package View;

import controller.AutoFuncController;
import controller.Controller;
import model.AutoFuncModel;
import model.MemberModel;

import java.util.Scanner;

public class UserInterface implements ViewInterface, Runnable {
    private Scanner input;
    private Controller controller;
    public UserInterface() {
        input = new Scanner(System.in);
        BirthDayCLI();


    }

    public void BirthDayCLI() {
        MemberModel M = new MemberModel();
        M.BirthdayPointAuto();
    }




    @Override
    public void start() {
        new Thread(this).run();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }


    public void run() {

        System.out.println("Welcome to the clothing store management system");


    }


    public void Rafi() {
        System.out.println("Welcome to the clothing store management system");

    }
}