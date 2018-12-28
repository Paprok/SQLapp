package com.codecool.app.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class TerminalView implements View {

    @Override
    public void printMenu() {
        String menu = "1. Search\n" +
                "0. Exit";
        System.out.println(menu);
    }

    @Override
    public int getInt() throws InputMismatchException{
        int option;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Option: ");
            String input = br.readLine();
            option =  Integer.parseInt(input);
        } catch (IOException e){
            throw new InputMismatchException("Please choose valid option");
        }
        return option;
    }
}
