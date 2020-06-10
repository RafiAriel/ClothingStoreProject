package driver;
import View.UserInterface;
import View.ViewInterface;
import controller.AutoFuncController;
import controller.Controller;
import controller.OpenController;
import model.AutoFuncModel;
import model.Model;
import model.OpenModel;

public class MVCDriver {

    public static void main(String[] args) {
        UserInterface view = new UserInterface();
        Model model = new OpenModel();
        Controller Controller = new OpenController(view, model);
        view.start();



    }

}

