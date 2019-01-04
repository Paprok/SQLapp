package com.codecool.app;

import com.codecool.app.connectors.Connector;
import com.codecool.app.controllers.Controller;
import com.codecool.app.dao.DAOSimple;
import com.codecool.app.dao.DAOSimpleSQL;
import com.codecool.app.views.View;

import java.sql.Connection;

public class DesktopApp {
    private View view;
    private Connection connection;
    private DAOSimple daoSimple;
    private Controller controller;

    public DesktopApp(View view) {
        this.view = view;
        this.connection = Connector.getConnection();
        this.daoSimple = new DAOSimpleSQL(connection);
        this.controller = new Controller(daoSimple, view);
    }

    //TODO: Ask about clean way to manage those shitty queries, is hashmap ok (stored in daoSQL) whereas here only list of menu entries?
    //TODO: Loading from file? and creating list? Idk
    //TODO: How to manage cleanly those menus? Create hasnmap of String menu : reflection of method? XD or new class holding necessary info? hmm
    public void run() {
        int option = -1;
        while (option != 0) {
            view.printMenu();
            option = view.getInt();
            switch (option) {
                case 1:
                    controller.printMentorNames();
                    break;
                case 2:
                    controller.printMiscolcsNicks();
                    break;
                case 3:
                    controller.printCarols();
                    break;
                case 4:
                    controller.printApplicantsContactsByMail();
                    break;
                case 5:
                    controller.insertMarcus();
                    controller.printApplicant54823();
                    break;
                case 6:
                    controller.updateForeman();
                    break;
                case 7:
                    controller.deleteMariseuDomain();
            }
        }
    }
}
