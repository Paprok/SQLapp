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
}
