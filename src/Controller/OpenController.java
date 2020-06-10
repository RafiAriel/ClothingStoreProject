package controller;

import View.ViewInterface;
import model.Model;

public class OpenController implements Controller {
    ViewInterface viewInterface;
    Model model;

    public OpenController(ViewInterface viewInterface, Model model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }
}
