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

    /**
     *
     */
    public void processUser() {
        Scanner scanner = new Scanner(System.in);

        getInputs(scanner);

        System.out.println(model);

    }

    /**
     * Inputs from user
     * @param scanner {@code Scanner}
     */
    private void getInputs(Scanner scanner) {
        model.setFirstName(getUserInputRegex(scanner, View.INPUT_FIRST_NAME, Regexes.NAME));
        model.setLastName(getUserInputRegex(scanner, View.INPUT_LAST_NAME, Regexes.NAME));
        model.setMiddleName(getUserInputRegex(scanner, View.INPUT_MIDDLE_NAME, Regexes.NAME));
        model.setFullName();
        model.setNickName(getUserInputRegex(scanner, View.INPUT_NICKNAME, Regexes.USER_NAME));
        model.setComment(getUserInputRegex(scanner, View.INPUT_COMMENT, Regexes.COMMENT));
        model.seteMail(getUserInputRegex(scanner, View.INPUT_EMAIL, Regexes.EMAIL));
    }

    /**
     * Checks users Input for regex. If it matches, returns input. If not,
     * user is asked again
     * @param sc Input {@code Scanner}
     * @param message Message info to print for user
     * @param regex regular expression to match user input
     * @return user input
     */
    private String getUserInputRegex(Scanner sc, String message, String regex) {
        view.printMessage(message);
        String input = sc.next();

        while (!input.matches(regex)) {
            view.printMessage(View.WRONG_INPUT);
            input = sc.next();
        }

        return input;
    }

}
