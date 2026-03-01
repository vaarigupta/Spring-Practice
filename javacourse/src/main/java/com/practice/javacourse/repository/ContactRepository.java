package com.practice.javacourse.repository;

import com.practice.javacourse.exception.ContactNotFoundException;
import com.practice.javacourse.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    public int findContactById(String id) {
        return IntStream.range(0, contacts.size())
                .filter(index -> contacts.get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException(id));
    }


    //get single contact
    public Contact getContact(String id){
        return contacts.get(findContactById(id));
       }

    //get list of contacts
    public List<Contact> getContacts(){
        return contacts;
    }

    //create contact
    public void createContact(Contact contact){
        contacts.add(contact);
    }

    //update contact
    public void updateContact(String id, Contact contact){
        contacts.set(findContactById(id),contact);
    }

    //delete contact
    public void deleteContact(String id ){
        contacts.remove(findContactById(id));
    }


}
