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

    @Autowired
    private ContactRepository contactRepository;


    private int findIndexById(String id){
        return IntStream.range(0, contactRepository.getContacts().size())
                .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @Override
    public Contact getContactById(String id){
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void createContact(Contact contact) {
        contactRepository.createContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.getContacts();
    }

    @Override
    public void updateContact(String id, Contact contact){
        contactRepository.updateContact(findIndexById(id),contact);
    }

    @Override
    public void deleteContact(String id){
        contactRepository.deleteContact(findIndexById(id));
    }


}
