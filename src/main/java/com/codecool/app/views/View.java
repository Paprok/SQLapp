package com.codecool.app.views;

import java.util.InputMismatchException;

public interface View {
    int getInt() throws InputMismatchException;
    void printMenu();
}
