package com.example.crud_agenda.service;

import com.example.crud_agenda.entity.Contact;
import com.example.crud_agenda.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    };

    public Contact findById(Integer id){
        return contactRepository.findById(id).orElse(null);
    };

    public Contact create(@RequestBody Contact contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    };

    public Contact update(Integer id, Contact form){
        Contact contacFromDB = findById(id);

        contacFromDB.setName(form.getName());
        contacFromDB.setEmail(form.getEmail());

        return contactRepository.save(contacFromDB);
    };

    public void delete(Integer id){
        Contact contac = findById(id);
        contactRepository.delete(contac);
    };
}
