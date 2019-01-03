package com.codecool.app.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;

public class TerminalView implements View {

    @Override
    public void printMenu() {
        String menu = "1. Print Mentors' Names\n" +
                "2. Print Miscolcs' Mentors Nicknames\n" +
                "3. Print Each Carol's Numbers\n" +
                "4. Print applicants contact with given mail\n" +
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
        } catch (IOException | NumberFormatException e){
            throw new InputMismatchException("Please choose valid option");
        }
        return option;
    }

    @Override
    public void printResults(List<List<String>> results) {
        for (List<String> line : results) {
            printLine(line);
        }
    }

    private void printLine(List<String> line){
        StringBuilder builder = new StringBuilder();
        for (String word : line) {
            builder.append(word);
            builder.append(" | ");
        }
        System.out.println(builder.toString());
    }
}
