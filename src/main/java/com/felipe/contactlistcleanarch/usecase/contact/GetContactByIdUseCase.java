package com.felipe.contactlistcleanarch.usecase.contact;

import com.felipe.contactlistcleanarch.entity.contact.exception.ContactNotFoundException;
import com.felipe.contactlistcleanarch.entity.contact.gateway.ContactGateway;
import com.felipe.contactlistcleanarch.entity.contact.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class GetContactByIdUseCase {

    private final ContactGateway contactGateway;

    public GetContactByIdUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public Output execute(Input input) {
        return contactGateway.findById(input.id())
                .map(Output::new)
                .orElseThrow(ContactNotFoundException::new);
    }

    public record Input(Long id) {}

    public record Output(Contact contact) {}

}
