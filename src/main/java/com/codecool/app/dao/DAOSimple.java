package com.codecool.app.dao;

import com.codecool.app.models.Applicant;

import java.util.List;
import java.util.NoSuchElementException;

public interface DAOSimple {
    List<List<String>> getMentorNames() throws NoSuchElementException;
    List<List<String>> getMiscolcNicks() throws NoSuchElementException;
    List<List<String>> getCarols() throws NoSuchElementException;
    List<List<String>> getApplicantContactByMail() throws NoSuchElementException;
    boolean insertApplicant(Applicant applicant);
    boolean insertMarcus();
    List<List<String>> selectApplicantByCode(int application_code) throws NoSuchElementException;
    List<List<String>> selectApplication54823();
    boolean updateForeman() throws NoSuchElementException;
    List<List<String>> getForeman() throws NoSuchElementException;
    boolean deleteApplicantWithMailMariseu() throws NoSuchElementException;
}
