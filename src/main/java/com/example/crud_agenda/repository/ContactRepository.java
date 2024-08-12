package com.example.crud_agenda.repository;

import com.example.crud_agenda.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
