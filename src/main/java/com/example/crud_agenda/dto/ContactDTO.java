package com.example.crud_agenda.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContactDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @Email(message = "El email es invalido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    public ContactDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
