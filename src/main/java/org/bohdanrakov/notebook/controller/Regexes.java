package org.bohdanrakov.notebook.controller;

public interface Regexes {

    String NAME = "^[A-Z][-a-zA-Z]+$";
    String COMMENT = ".*";
    String USER_NAME = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    String EMAIL = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
}
