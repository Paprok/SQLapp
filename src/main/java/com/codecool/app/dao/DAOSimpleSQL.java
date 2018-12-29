package com.codecool.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DAOSimpleSQL implements DAOSimple {
    private Connection connection;

    public DAOSimpleSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<List<String>> getMentorNames() throws NoSuchElementException {
        String sql = "";
        ResultSet resultSet;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e){
            throw new NoSuchElementException("No names found");
        }
        return convertResultSetToList(resultSet);
    }

    private List<List<String>> convertResultSetToList(ResultSet resultSet){
        List<List<String>> list = new ArrayList<>();
        //TODO
        return list;
    }
}
