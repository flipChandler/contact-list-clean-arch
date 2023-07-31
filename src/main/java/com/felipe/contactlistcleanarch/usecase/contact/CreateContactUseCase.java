package com.felipe.contactlistcleanarch.usecase.contact;

import com.felipe.contactlistcleanarch.entity.contact.gateway.ContactGateway;
import com.felipe.contactlistcleanarch.entity.contact.model.Contact;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateContactUseCase {

    private final ContactGateway contactGateway;

    public CreateContactUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    @Transactional
    public void execute(Input input) {
        var contact = Contact.of(input.name(), input.phone());
        contactGateway.create(contact);
    }

    public record Input(String name, String phone) {}

}
