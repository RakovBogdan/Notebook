package org.bohdanrakov.notebook.controller;

import org.bohdanrakov.notebook.model.AllUsers;
import org.bohdanrakov.notebook.model.LoginExistsException;
import org.bohdanrakov.notebook.model.Model;
import org.bohdanrakov.notebook.view.View;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    /**
     * allUsers is a stub for a database with users
     */
    private AllUsers allUsers = new AllUsers();

    public Controller(View view) {
        this.view = view;
    }


    //Working method
    public void processUser() {
        Scanner scanner = new Scanner(System.in);

        //Hardcoded creating of new user with login. To try LoginExistsException
        allUsers.addUserWithLoginForTest("bohdan");

        constructModelFromUserInput(scanner);

        //Adding another user with same login just before this one
        // with the same name for testing concurrent input
        allUsers.addUserWithLoginForTest(model.getLogin());

        addUserToAllUsers(model, scanner);

        commandViewToPrintAllUsers();
    }

    /**
     * Sets the model fields from user input for future storage in AllUsers
     * @param scanner {@code Scanner}
     */
    private void constructModelFromUserInput(Scanner scanner) {

        model = new Model.Builder()
                .login(getLoginFromUser(scanner))
                .firstName(getUserInputRegex(scanner, View.INPUT_FIRST_NAME, Regexes.NAME))
                .lastName(getUserInputRegex(scanner, View.INPUT_LAST_NAME, Regexes.NAME))
                .middleName(getUserInputRegex(scanner, View.INPUT_MIDDLE_NAME, Regexes.NAME))
                .nickName(getUserInputRegex(scanner, View.INPUT_NICKNAME, Regexes.USER_NAME))
                .comment(getUserInputRegex(scanner, View.INPUT_COMMENT, Regexes.COMMENT))
                .eMail(getUserInputRegex(scanner, View.INPUT_EMAIL, Regexes.EMAIL))
                .build();
    }

    /**
     * Method that adds user to the database-like stub allUsers
     * checks whether login is occupied. If if is, user is asked to change
     * the login
     * @param model {@code Model}
     * @param scanner {@code Scanner}
     */
    private void addUserToAllUsers(Model model, Scanner scanner) {
        while (true) {
            try {
                allUsers.addUser(model);
                break;
            } catch (LoginExistsException e) {
                view.printMessage(e.getMessage());
                model.setLogin(getLoginFromUser(scanner));
            }
        }
    }

    /**
     * Method that repeatedly asks user to input a login. If login exists, user is asked again,
     * until user chooses login which is not occupied
     * @param sc {@code Scanner}
     * @return input from user (login)
     */
    private String getLoginFromUser(Scanner sc) {
        String login = getUserInputRegex(sc, View.INPUT_LOGIN, Regexes.USER_NAME);
        while (allUsers.isLoginOccupied(login)) {
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

    private void commandViewToPrintAllUsers() {
        for (Model user: allUsers.getUsers()) {
            System.out.println(user);
        }
    }
}
