package com.practice.javacourse.service;

import com.practice.javacourse.exception.ContactNotFoundException;
import com.practice.javacourse.model.Contact;
import com.practice.javacourse.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class ContactServiceImpl implements ContactService{


    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }


    @Override
    public Contact getContactById(String id){
        return contactRepository.getContact(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.getContacts();
    }

    @Override
    public void createContact(Contact contact) {
        contactRepository.createContact(contact);
    }


    @Override
    public void updateContact(String id, Contact contact){
        contactRepository.updateContact(id,contact);
    }

    @Override
    public void deleteContact(String id){
        contactRepository.deleteContact(id);
    }


}
