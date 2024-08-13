package com.example.crud_agenda;

import com.example.crud_agenda.entity.Contact;
import com.example.crud_agenda.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CrudAgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAgendaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return args -> {
			List<Contact> contacts = Arrays.asList(
					new Contact("Mariela Rodriguez", "mariela@gmail.com", LocalDateTime.now()),
					new Contact("Karlos Rodriguez", "karlos@gmail.com", LocalDateTime.now()),
					new Contact("Francisco Lopez", "francisco@gmail.com", LocalDateTime.now()),
					new Contact("Ana Ferreira", "ana@gmail.com", LocalDateTime.now()),
					new Contact("Juan Nuñez", "juan@gmail.com", LocalDateTime.now())
			);

			contactRepository.saveAll(contacts);
		};
	}

	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
