package controller;

import View.ViewInterface;
import model.OpenModel;

public class OpenController {
    ViewInterface viewInterface;
    OpenModel model;

    public OpenController(ViewInterface viewInterface, OpenModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }

    public OpenController() {

    }
}
