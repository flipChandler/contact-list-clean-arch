package com.felipe.contactlistcleanarch.usecase.contact;

import com.felipe.contactlistcleanarch.entity.contact.gateway.ContactGateway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateContactUseCase {

    private final ContactGateway contactGateway;

    public UpdateContactUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    @Transactional
    public void execute(Input input) {
        contactGateway.findById(input.id())
                .ifPresent(contact -> {
                            contact.updateName(input.name());
                            contact.updatePhone(input.phone());
                            contactGateway.update(contact);
                        });
    }

    public record Input(Long id, String name, String phone) {}
}
