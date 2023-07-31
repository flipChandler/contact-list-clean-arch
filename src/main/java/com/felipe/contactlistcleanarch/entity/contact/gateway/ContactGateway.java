package com.felipe.contactlistcleanarch.entity.contact.gateway;

import com.felipe.contactlistcleanarch.entity.contact.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactGateway {

    List<Contact> getAll();

    void create(Contact contact);

    void update(Contact contact);

    void delete(Long id);

    Optional<Contact> findById(Long id);

    List<Contact> searchByName(String name);

}
