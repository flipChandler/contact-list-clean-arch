package com.felipe.contactlistcleanarch.infra.contact.controller;

import com.felipe.contactlistcleanarch.usecase.contact.UpdateContactUseCase;
import com.felipe.contactlistcleanarch.usecase.contact.UpdateContactUseCase.Input;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateContactController {

    private final UpdateContactUseCase updateContactUseCase;

    public UpdateContactController(UpdateContactUseCase updateContactUseCase) {
        this.updateContactUseCase = updateContactUseCase;
    }

    @PutMapping("api/contacts/{id}")
    public void updateContact(@PathVariable Long id, @RequestBody Request request) {
        updateContactUseCase.execute(new Input(id, request.name(), request.phone()));
    }

    public record Request(String name, String phone) {}

}
