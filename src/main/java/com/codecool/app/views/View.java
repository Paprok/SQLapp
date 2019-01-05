package com.codecool.app.views;

import java.util.InputMismatchException;
import java.util.List;

public interface View {
    int getInt() throws InputMismatchException;
    void printMenu();
    void printResults(List<List<String>> results);
    void printMessage(String message);
    String getInput() throws  InputMismatchException;
}
