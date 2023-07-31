package com.felipe.contactlistcleanarch.infra.gateway;

import com.felipe.contactlistcleanarch.entity.contact.gateway.ContactGateway;
import com.felipe.contactlistcleanarch.entity.contact.model.Contact;
import com.felipe.contactlistcleanarch.infra.config.db.ContactRepository;
import com.felipe.contactlistcleanarch.infra.config.db.ContactSchema;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ContactDatabaseGateway implements ContactGateway {

    private final ContactRepository contactRepository;

    public ContactDatabaseGateway(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll()
                .stream()
                .map(Contact::of)
                .collect(Collectors.toList());
    }

    @Override
    public void create(Contact contact) {
        contactRepository.save(ContactSchema.of(contact.getName(), contact.getPhone()));
    }

    @Override
    public void update(Contact contact) {
        contactRepository.save(ContactSchema.of(contact));
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id)
                .map(Contact::of);
    }

    @Override
    public List<Contact> searchByName(String name) {
        return contactRepository.searchByNameContaining(name)
                .stream()
                .map(Contact::of)
                .collect(Collectors.toList());
    }

}
