package com.practice.javacourse.service;

import com.practice.javacourse.exception.NoContactException;
import com.practice.javacourse.model.Contact;

import java.util.List;

public interface ContactService {

    Contact getContactById(String id) throws NoContactException;
    void createContact(Contact contact);
    List<Contact> getAllContacts();
    void updateContact(String id, Contact contact) throws NoContactException;
    void deleteContact(String id) throws NoContactException;
}
