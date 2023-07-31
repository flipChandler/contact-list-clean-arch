package com.felipe.contactlistcleanarch.usecase.contact;

import com.felipe.contactlistcleanarch.entity.contact.gateway.ContactGateway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteContactUseCase {

    private final ContactGateway contactGateway;

    public DeleteContactUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    @Transactional
    public void execute(Input input) {
        contactGateway.delete(input.id());
    }

    public record Input(Long id) {}

}
