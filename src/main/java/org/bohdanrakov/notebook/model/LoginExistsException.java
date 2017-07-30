package org.bohdanrakov.notebook.model;

public class LoginExistsException extends Exception {

    LoginExistsException(String msg) {
        super(msg);
    }
}
