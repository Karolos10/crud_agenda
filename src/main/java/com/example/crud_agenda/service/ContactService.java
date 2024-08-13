package com.example.crud_agenda.service;

import com.example.crud_agenda.dto.ContactDTO;
import com.example.crud_agenda.entity.Contact;
import com.example.crud_agenda.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;


    public ContactService(ContactRepository contactRepository, ModelMapper mapper) {
        this.contactRepository = contactRepository;
        this.mapper = mapper;
    }

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    };

    public Contact findById(Integer id){
        return contactRepository.findById(id).orElse(null);
    };

    public Contact create(@RequestBody ContactDTO contactDTO){
        Contact contact = mapper.map(contactDTO, Contact.class);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    };

    public Contact update(Integer id, ContactDTO contactDTO){
        Contact contacFromDB = findById(id);

        mapper.map(contactDTO, contacFromDB);

        return contactRepository.save(contacFromDB);
    };

    public void delete(Integer id){
        Contact contac = findById(id);
        contactRepository.delete(contac);
    };
}
