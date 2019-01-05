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
                "5. Add Marcus\n" +
                "6. Update Foreman's phone\n" +
                "7. Delete applicants with mail @mariseu" +
                "8. Advanced Search" +
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

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            System.out.println("Option: ");
            input = br.readLine();
        } catch (IOException e){
            throw new InputMismatchException("Please enter sth to search");
        }
        return input;
    }
}
