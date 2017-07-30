package org.bohdanrakov.notebook.model;

import java.util.ArrayList;
import java.util.List;

public class AllUsers {

    private List<Model> users = new ArrayList<>();

    public AllUsers() {
        Model user1 = new Model();
        user1.setLogin("bohdan");
        users.add(user1);
    }

    public List<Model> getUsers() {
        return users;
    }

    public void addUser(Model user) throws LoginExistsException {
        if (isLoginOccupied(user.getLogin())) {
            throw new LoginExistsException("Login " + user.getLogin() + " already exists");
        }

        users.add(user);
    }

    public boolean isLoginOccupied(String login) {
        for (Model record: users) {
            if (login.equals(record.getLogin())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return users.toString();
    }
}
