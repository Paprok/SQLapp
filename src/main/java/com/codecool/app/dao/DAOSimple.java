package com.codecool.app.dao;

import java.util.List;
import java.util.NoSuchElementException;

public interface DAOSimple {
    List<List<String>> getMentorNames() throws NoSuchElementException;
}
