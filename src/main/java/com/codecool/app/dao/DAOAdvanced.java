package com.codecool.app.dao;

import java.util.List;
import java.util.NoSuchElementException;

public interface DAOAdvanced {
    List<List<String>> search(String[] words) throws NoSuchElementException;
}
