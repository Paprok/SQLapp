package com.codecool.app.dao;

import java.sql.*;
import java.util.*;

public class DAOAdvancedSQL implements DAOAdvanced {
    private Connection connection;
    private Map<String, String> applicantsColumnNamesTypes;
    private Map<String, String> mentorsColumnNamesTypes;
    private List<List<String>> results;

    public DAOAdvancedSQL(Connection connection) {
        this.connection = connection;
        this.applicantsColumnNamesTypes = new HashMap<>();
        this.mentorsColumnNamesTypes = new HashMap<>();
    }

    @Override
    public List<List<String>> search(String[] words) throws NoSuchElementException {
        results = new ArrayList<>();
        setColumnNames();
        for(String word: words) {
            searchWord(word);
        }
        return results;
    }

    private void searchWord(String word) { ;
        System.out.println(word);

        for (Map.Entry appEntry : this.applicantsColumnNamesTypes.entrySet()) {        // should be method with 2 arguments and for
            addResults(word, appEntry, "applicants");
        }

        for (Map.Entry mentorEntry : this.mentorsColumnNamesTypes.entrySet()) {
            addResults(word, mentorEntry, "mentors");
        }
    }

    private void setColumnNames() throws NoSuchElementException {
        try {
            addApplicantColumns();
            addMentorColumns(); // should have name argument added to class through injection
        } catch (SQLException e) {
            throw new NoSuchElementException("couldn't find column names");
        }
    }

    private void addApplicantColumns() throws SQLException {
        ResultSet resultSet = connection.prepareStatement("select * from applicants where 1<0").executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columns = metaData.getColumnCount();
        for (int i = 1; i <= columns; i++) {
            String columnName = metaData.getColumnName(i);
            String columnType = metaData.getColumnTypeName(i);
            this.applicantsColumnNamesTypes.putIfAbsent(columnName, columnType);
            metaData.getColumnType(i);
        }

    }

    private void addMentorColumns() throws SQLException {
        ResultSet resultSet = connection.prepareStatement("select * from mentors where 1<0").executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columns = metaData.getColumnCount();
        for (int i = 1; i <= columns; i++) {
            String columnName = metaData.getColumnName(i);
            String columnType = metaData.getColumnTypeName(i);
            this.mentorsColumnNamesTypes.putIfAbsent(columnName, columnType);
            metaData.getColumnType(i);
        }

    }

//    private void addApplicantColumns(DatabaseMetaData metaData) throws SQLException {
//        ResultSet rs = metaData.getColumns(null, null, "applicants", null);
//        while(rs.next()){
//            applicantsColumnNamesTypes.add(rs.getString(4));
//        }
//    }
//
//    private void addMentorColumns(DatabaseMetaData metaData) throws SQLException {
//        ResultSet rs = metaData.getColumns(null, null, "mentors", null);
//        while(rs.next()){
//            mentorsColumnNamesTypes.add(rs.getString(4));
//        }
//    }

    private void addResults(String word, Map.Entry<String, String> columnEntry, String tableName) throws NoSuchElementException {
        String query = getQuery(columnEntry.getKey(), tableName);
        try {
            ResultSet resultSet = getResultSet(word, query, columnEntry.getValue());
            addResult(resultSet);
        } catch (SQLException e) {
//            throw new NoSuchElementException(String.format("Couldnt connect to %s", tableName));
        } catch (NumberFormatException e){

        }
    }

    private ResultSet getResultSet(String word, String query, String columnType) throws SQLException, NumberFormatException {
        PreparedStatement ps = connection.prepareStatement(query);
        System.out.println(columnType);

        if(columnType.equalsIgnoreCase("text")){
            ps.setString(1, word);
        } else {
            int number = Integer.parseInt(word);
            ps.setInt(1, number);
        }
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }

    private String getQuery(String columnName, String tableName) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ");
        queryBuilder.append(tableName);
        queryBuilder.append(" WHERE ");
        queryBuilder.append(columnName);
        queryBuilder.append(" = ? ");
        System.out.println(queryBuilder.toString());
        return queryBuilder.toString();
    }


    private void addResult(ResultSet resultSet) throws SQLException {
        List<String> line;
        while (resultSet.next()) {
            line = new ArrayList<>();
            for (int i = 1; i <= columnNumber(resultSet); i++) {
                String result = resultSet.getString(i);
                line.add(result);
            }
            results.add(line);
        }
    }

    private int columnNumber(ResultSet resultSet) throws SQLException {
        ResultSetMetaData data = resultSet.getMetaData();
        return data.getColumnCount();
    }

}
