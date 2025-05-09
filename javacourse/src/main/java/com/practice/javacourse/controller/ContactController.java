package com.practice.javacourse.controller;

import com.practice.javacourse.exception.ContactNotFoundException;
import com.practice.javacourse.model.Contact;
import com.practice.javacourse.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class ContactController {

     @Autowired
     private ContactService contactService;

     @GetMapping("/contact/all")
    public ResponseEntity<List<Contact>> getAllContact(){
        List<Contact> contacts = contactService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id){
           Contact contact = contactService.getContactById(id);
           return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact){
        contactService.createContact(contact);
        return new ResponseEntity<>(contact,HttpStatus.CREATED);

    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable  String id,@Valid @RequestBody Contact contact){
             contactService.updateContact(id,contact);
             Contact updatedContact = contactService.getContactById(id);
             return new ResponseEntity<>(updatedContact,HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id){
             contactService.deleteContact(id);
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
