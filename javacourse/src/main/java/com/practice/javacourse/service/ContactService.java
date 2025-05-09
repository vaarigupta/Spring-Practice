package com.practice.javacourse.service;

import com.practice.javacourse.exception.ContactNotFoundException;
import com.practice.javacourse.model.Contact;

import java.util.List;

public interface ContactService {

    Contact getContactById(String id) ;
    void createContact(Contact contact);
    List<Contact> getAllContacts();
    void updateContact(String id, Contact contact) ;
    void deleteContact(String id);
}
