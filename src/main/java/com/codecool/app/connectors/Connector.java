package com.codecool.app.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static Connection connection;

    public static Connection getConnection(){
        if(connection == null){
            try {
                createConnection();
            } catch (SQLException e){
                System.out.println("Couldn't connect to DB");
            }
        }
        return connection;
    }

    private static void createConnection() throws SQLException{
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sqlapp","host","admin123");
        System.out.println("Opened database sucessfully");
    }
}
