package com.practice.javacourse.repository;

import com.practice.javacourse.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    //get list of contacts
    public List<Contact> getContacts(){
        return contacts;
    }

    //get single contact
    public Contact getContact(int index){ return contacts.get(index);}

    //save contact
    public void saveContact(Contact contact){
        contacts.add(contact);
    }

    //update contact
    public void updateContact(int index, Contact contact){
        contacts.set(index,contact);
    }

    //delete contact
    public void deleteContact(int index){
        contacts.remove(index);
    }


}
