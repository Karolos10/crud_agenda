package com.example.crud_agenda.controller;

import com.example.crud_agenda.entity.Contact;
import com.example.crud_agenda.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contactList")
    public Iterable<Contact> list(){
        return contactRepository.findAll();
    }

    @GetMapping("/contactList/{id}")
    public Contact getById(@PathVariable Integer id){
        return contactRepository.findById(id).orElse(null);
    };

    @PostMapping("/createContact")
    public Contact create(@RequestBody Contact contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @PutMapping("/updateContact/{id}")
    public Contact update(@PathVariable Integer id, @RequestBody Contact form){
        Contact contacFromDB = contactRepository.findById(id).orElse(null);

        contacFromDB.setName(form.getName());
        contacFromDB.setEmail(form.getEmail());

        return contactRepository.save(contacFromDB);
    };
}
