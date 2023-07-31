package com.felipe.contactlistcleanarch.infra.config.db;

import com.felipe.contactlistcleanarch.entity.contact.model.Contact;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class ContactSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;

    public ContactSchema() {
    }

    private ContactSchema(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    private ContactSchema(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public static ContactSchema of(Contact contact) {
        return new ContactSchema(contact.getId(), contact.getName(), contact.getPhone());
    }

    public static ContactSchema of(String name, String phone) {
        return new ContactSchema(name, phone);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
