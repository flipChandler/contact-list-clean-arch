package com.felipe.contactlistcleanarch.entity.contact.model;

import com.felipe.contactlistcleanarch.infra.config.db.ContactSchema;

public class Contact {

    private Long id;
    private String name;
    private String phone;

    private Contact(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    private Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public static Contact of(String name, String phone) {
        return new Contact(name, phone);
    }

    public static Contact of(Long id, String name, String phone) {
        return new Contact(id, name, phone);
    }

    public static Contact of(ContactSchema contactSchema) {
        return new Contact(contactSchema.getId(), contactSchema.getName(), contactSchema.getPhone());
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

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

}
