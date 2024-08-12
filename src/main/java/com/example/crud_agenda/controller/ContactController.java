package com.example.crud_agenda.controller;

import com.example.crud_agenda.entity.Contact;
import com.example.crud_agenda.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contactList")
    Iterable<Contact> list(){
        return contactRepository.findAll();
    }
}
