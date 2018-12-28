package com.codecool.app;

import com.codecool.app.views.View;

public class TerminalApp {
    private View view;

    public TerminalApp(View view) {
        this.view = view;
    }

    public void run() {
        int option = -1;
        while (option != 0) {
            view.printMenu();
            option = view.getInt();
            switch (option) {
                case 1:
            }
        }
    }
}
