package com.codecool.app.controllers;

import com.codecool.app.dao.DAOAdvanced;
import com.codecool.app.dao.DAOSimple;
import com.codecool.app.views.View;

import java.sql.ResultSet;
import java.util.List;
import java.util.NoSuchElementException;

public class Controller {
    private DAOSimple daoSimple;
    private DAOAdvanced daoAdvanced;
    private View view;

    public Controller(DAOSimple daoSimple, DAOAdvanced daoAdvanced, View view) {
        this.daoSimple = daoSimple;
        this.daoAdvanced = daoAdvanced;
        this.view = view;
    }

    public void printMentorNames() {
        try {
            List<List<String>> names = daoSimple.getMentorNames();
            this.view.printResults(names);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printMiscolcsNicks() {
        try {
            List<List<String>> nicks = daoSimple.getMiscolcNicks();
            this.view.printResults(nicks);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printCarols(){
        try{
            List<List<String>> carols = daoSimple.getCarols();
            this.view.printResults(carols);
        } catch (NoSuchElementException e ){
            System.out.println(e.getMessage());
        }
    }

    public void printApplicantsContactsByMail(){
        try{
            List<List<String>> contacts = daoSimple.getApplicantContactByMail();
            this.view.printResults(contacts);
        } catch (NoSuchElementException e ){
            System.out.println(e.getMessage());
        }
    }

    public void insertMarcus(){
        boolean isSuccessful = this.daoSimple.insertMarcus();
        if(isSuccessful){
            this.view.printMessage("Added Marcus sucessfully :)");
        } else {
            this.view.printMessage("Couldn't add Marcus, check connection");
        }
    }

    public void printApplicant54823(){
        try{
            List<List<String>> applicants = this.daoSimple.selectApplication54823();
            this.view.printResults(applicants);
        } catch (NoSuchElementException e){
            this.view.printMessage(e.getMessage());
        }
    }

    public void updateForeman(){
        try{
            this.daoSimple.updateForeman();
            this.view.printMessage("updated Foreman");
            this.view.printResults(this.daoSimple.getForeman()); // na chuj to komu? nie lepiej zbierać przy update?
        } catch (NoSuchElementException e){
            this.view.printMessage(e.getMessage());
        }
    }

    public void deleteMariseuDomain(){
        try{
            this.daoSimple.deleteApplicantWithMailMariseu();
            this.view.printMessage("deleted applicants with mail on mariseu domain");
        } catch (NoSuchElementException e){
            this.view.printMessage(e.getMessage());
        }
    }

    public void runAdvancedSearch(){
        this.view.printMessage("Please insert words to search:");
        String input = this.view.getInput();
        input = input.replace("[\\S+]"," ");
        String[] words = input.split(" ");
        try {
            List<List<String>> foundResults = this.daoAdvanced.search(words);
            this.view.printResults(foundResults);
        } catch (NoSuchElementException e ){
            view.printMessage(e.getMessage());
        }
    }
}
