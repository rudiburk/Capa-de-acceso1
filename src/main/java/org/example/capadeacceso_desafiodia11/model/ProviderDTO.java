package org.example.capadeacceso_desafiodia11.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProviderDTO {
    private int id;
    private String name;
    private String rut;
    private String address;
    private String email;
    private String phoneNumber;
    private String contact;
    private String phoneNumberContact;

    public ProviderDTO(String name, String rut, String address, String email, String phoneNumber, String contact, String phoneNumberContact) {
        this.name = name;
        this.rut = rut;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contact = contact;
        this.phoneNumberContact = phoneNumberContact;
    }
}
