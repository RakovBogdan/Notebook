package org.bohdanrakov.notebook.controller;

import org.bohdanrakov.notebook.model.AllUsers;
import org.bohdanrakov.notebook.model.LoginExistsException;
import org.bohdanrakov.notebook.model.Model;
import org.bohdanrakov.notebook.view.View;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    private AllUsers allUsers = new AllUsers();

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

        addUser(model, scanner);

        System.out.println(allUsers);

    }

    /**
     * Inputs from user
     * @param scanner {@code Scanner}
     */
    private void getInputs(Scanner scanner) {
        model.setLogin(getLoginFromUser(scanner));
        model.setFirstName(getUserInputRegex(scanner, View.INPUT_FIRST_NAME, Regexes.NAME));
        model.setLastName(getUserInputRegex(scanner, View.INPUT_LAST_NAME, Regexes.NAME));
        model.setMiddleName(getUserInputRegex(scanner, View.INPUT_MIDDLE_NAME, Regexes.NAME));
        model.setFullName();
        model.setNickName(getUserInputRegex(scanner, View.INPUT_NICKNAME, Regexes.USER_NAME));
        model.setComment(getUserInputRegex(scanner, View.INPUT_COMMENT, Regexes.COMMENT));
        model.seteMail(getUserInputRegex(scanner, View.INPUT_EMAIL, Regexes.EMAIL));
    }

    public void addUser(Model model, Scanner scanner) {
        while (true) {
            try {
                allUsers.addUser(model);
                break;
            } catch (LoginExistsException e) {
                view.printMessage(e.getMessage());
                model.setLogin(getUserInputRegex(scanner, View.INPUT_LOGIN, Regexes.USER_NAME));
            }
        }
    }

    public String getLoginFromUser(Scanner sc) {
        String login = getUserInputRegex(sc, View.INPUT_LOGIN, Regexes.USER_NAME);
        while (!allUsers.isLoginOccupied(login)) {
            view.printMessage(View.LOGIN_OCCUPIED);
            login = getUserInputRegex(sc, View.INPUT_LOGIN, Regexes.USER_NAME);
        }
        return login;
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
