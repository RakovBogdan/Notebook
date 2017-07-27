package org.bohdanrakov.notebook;

import org.bohdanrakov.notebook.controller.Controller;
import org.bohdanrakov.notebook.model.Model;
import org.bohdanrakov.notebook.view.View;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
