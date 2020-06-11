package driver;
import view.UserInterface;
import view.ViewInterface;
import controller.OpenController;
import model.OpenModel;

public class MVCDriver {

    public static void main(String[] args) {
        ViewInterface view = new UserInterface();
        view.start();



    }

}

