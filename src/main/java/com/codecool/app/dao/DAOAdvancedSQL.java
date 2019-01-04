package com.codecool.app.dao;

import java.sql.Connection;
import java.util.List;

public class DAOAdvancedSQL implements DAOAdvanced {
    private Connection connection;

    public DAOAdvancedSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<List<String>> search(String[] words) {
        return null;
    }
}
