package org.bohdanrakov.notebook.controller;

public interface Regexes {

    String userName = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    String eMail = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
}
