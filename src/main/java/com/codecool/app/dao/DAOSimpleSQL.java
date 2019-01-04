package com.codecool.app.dao;

import com.codecool.app.models.Applicant;

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

    @Override
    public List<List<String>> getMiscolcNicks() throws NoSuchElementException {
        String sql = "SELECT nick_name FROM mentors " +
                "WHERE city LIKE 'Miskolc'";
        return getResults(sql);
    }

    @Override
    public List<List<String>> getCarols() throws NoSuchElementException {
        String sql = "SELECT CONCAT(first_name, last_name) AS full_name, phone_number FROM applicants " +
                "WHERE first_name LIKE 'Carol%'";
        return getResults(sql);
    }

    @Override
    public List<List<String>> getApplicantContactByMail() throws NoSuchElementException {
        String sql = "SELECT CONCAT(first_name, last_name) AS full_name, phone_number FROM applicants " +
                "WHERE email  like '%@adipiscingenimmi.edu'";
        return getResults(sql);
    }

    private List<List<String>> getResults(String sql) {
        ResultSet resultSet;
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            return convertResultSetToList(resultSet);
        } catch (SQLException e) {
            throw new NoSuchElementException("No records found found");
        }
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

    @Override
    public boolean insertApplicant(Applicant applicant) {
        String sql = "INSERT INTO applicants (first_name, last_name, phone_number, email, application_code) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            prepareStatementByApplicant(applicant, ps);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Couldn't insert applicant, check connection");
        }
        return false;
    }

    private void prepareStatementByApplicant(Applicant applicant, PreparedStatement ps) throws SQLException {
        ps.setString(1, applicant.getFirst_name());
        ps.setString(2, applicant.getLast_name());
        ps.setString(3, applicant.getPhone_number());
        ps.setString(4, applicant.getEmail());
        ps.setInt(5, applicant.getApplication_code());
    }

    @Override
    public boolean insertMarcus() {
        Applicant marcus = new Applicant("Markus", "Schaffarzyk", "003620/725-2666", "djnovus@groovecoverage.com", 54823);
        boolean isSuccessful = insertApplicant(marcus);
        return isSuccessful;
    }

    @Override
    public List<List<String>> selectApplicantByCode(int application_code) throws NoSuchElementException{
        String sql = "SELECT * FROM applicants WHERE application_code = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, application_code);
            ResultSet resultSet = ps.executeQuery();
            return convertResultSetToList(resultSet);
        } catch (SQLException e){
            throw new NoSuchElementException("Couldn't find applicant with given code");
        }
    }

    @Override
    public List<List<String>> selectApplication54823() {

        return selectApplicantByCode(54823);
    }
}
