package com.codecool.app.dao;

import java.sql.*;
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
        String sql = "SELECT first_name, last_name FROM mentors";
        return getResults(sql);
    }

    private List<List<String>> getResults(String sql) {
        ResultSet resultSet;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            return convertResultSetToList(resultSet);
        } catch (SQLException e) {
            throw new NoSuchElementException("No names found");
        }
    }

    @Override
    public List<List<String>> getMiscolcNicks() throws NoSuchElementException {
        String sql = "SELECT nick_name FROM mentors " +
                "WHERE city LIKE 'Miskolc'";
        return getResults(sql);
    }

    private List<List<String>> convertResultSetToList(ResultSet resultSet) throws SQLException {
        List<List<String>> list = new ArrayList<>();
        List<String> line;
        while (resultSet.next()) {
            line = new ArrayList<>();
            for (int i = 1; i <= columnNumber(resultSet); i++) {
                String result = resultSet.getString(i);
                line.add(result);
            }
            list.add(line);
        }
        return list;
    }

    private int columnNumber(ResultSet resultSet) throws SQLException {
        ResultSetMetaData data = resultSet.getMetaData();
        return data.getColumnCount();
    }
}
