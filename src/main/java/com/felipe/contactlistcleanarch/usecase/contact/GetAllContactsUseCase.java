package com.felipe.contactlistcleanarch.usecase.contact;

import com.felipe.contactlistcleanarch.entity.contact.gateway.ContactGateway;
import com.felipe.contactlistcleanarch.entity.contact.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllContactsUseCase {

    private final ContactGateway contactGateway;

    public GetAllContactsUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public List<Output> execute() {
        return contactGateway.getAll()
                .stream()
                .map(contact -> new Output(contact))
                .collect(Collectors.toList());
    }

    public record Output(Contact contact) {}
}
