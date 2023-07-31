package com.felipe.contactlistcleanarch.usecase.contact;

import com.felipe.contactlistcleanarch.entity.contact.gateway.ContactGateway;
import com.felipe.contactlistcleanarch.entity.contact.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchContactByNameUseCase {

    private final ContactGateway contactGateway;

    public SearchContactByNameUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public List<Output> execute(Input input) {
        return contactGateway.searchByName(input.name())
                .stream()
                .map(Output::new)
                .collect(Collectors.toList());
    }

    public record Input(String name) {}

    public record Output(Contact contact) {}
}
