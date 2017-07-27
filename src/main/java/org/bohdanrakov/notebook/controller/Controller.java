package org.bohdanrakov.notebook.controller;

import org.bohdanrakov.notebook.model.Model;
import org.bohdanrakov.notebook.view.View;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);


    }

    public String getUserInputRegex() {
        return "";
    }

}
