package com.codecool.app.controllers;

import com.codecool.app.dao.DAOSimple;
import com.codecool.app.views.View;

import java.util.List;
import java.util.NoSuchElementException;

public class Controller {
    private DAOSimple daoSimple;
    private View view;

    public Controller(DAOSimple daoSimple, View view) {
        this.daoSimple = daoSimple;
        this.view = view;
    }

    public void printMentorNames() {
        try {
            List<List<String>> names = daoSimple.getMentorNames();
            view.printResults(names);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printMiscolcsNicks() {
        try {
            List<List<String>> nicks = daoSimple.getMiscolcNicks();
            view.printResults(nicks);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printCarols(){
        try{
            List<List<String>> carols = daoSimple.getCarols();
            view.printResults(carols);
        } catch (NoSuchElementException e ){
            System.out.println(e.getMessage());
        }
    }

    public void printApplicantsContactsByMail(){
        try{
            List<List<String>> contacts = daoSimple.getApplicantContactByMail();
            view.printResults(contacts);
        } catch (NoSuchElementException e ){
            System.out.println(e.getMessage());
        }
    }

    public void insertMarcus(){
        boolean isSuccessful = this.daoSimple.insertMarcus();
        if(isSuccessful){
            view.printMessage("Added Marcus sucessfully :)");
        } else {
            view.printMessage("Couldn't add Marcus, check connection");
        }
    }

    public void printApplicant54823(){
        try{
            List<List<String>> applicants = this.daoSimple.selectApplication54823();
            view.printResults(applicants);
        } catch (NoSuchElementException e){
            view.printMessage(e.getMessage());
        }
    }
}
