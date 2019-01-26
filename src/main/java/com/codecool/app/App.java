package com.codecool.app;


import com.codecool.app.views.TerminalView;
import com.codecool.app.views.View;

public class App
{
    public static void main( String[] args )
    {
        View terminalView = new TerminalView();1
        DesktopApp app = new DesktopApp(terminalView);
        app.run();
    }
}
