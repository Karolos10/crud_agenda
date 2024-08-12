package com.example.crud_agenda.controller;

import com.example.crud_agenda.entity.Contact;
import com.example.crud_agenda.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contactList")
    public Iterable<Contact> list(){
        return contactService.findAll();
    }

    @GetMapping("/contactList/{id}")
    public Contact getById(@PathVariable Integer id){
        return contactService.findById(id);
    };

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createContact")
    public Contact create(@RequestBody Contact contact){
        return contactService.create(contact);
    }

    @PutMapping("/updateContact/{id}")
    public Contact update(@PathVariable Integer id, @RequestBody Contact form){

        return contactService.update(id, form);
    };

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteContact/{id}")
    public void delete(@PathVariable Integer id){
        contactService.delete(id);
    };
}
