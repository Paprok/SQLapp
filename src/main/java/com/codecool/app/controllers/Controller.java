package com.codecool.app.controllers;

import com.codecool.app.dao.DAOSimple;
import com.codecool.app.views.View;

import java.util.List;

public class Controller {
    private DAOSimple daoSimple;
    private View view;

    public Controller(DAOSimple daoSimple, View view) {
        this.daoSimple = daoSimple;
        this.view = view;
    }

    public void printMentorNames(){
        List<List<String>> names = daoSimple.getMentorNames();
        view.printResults(names);
    }
}
