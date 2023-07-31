package com.felipe.contactlistcleanarch.infra.contact.controller;


import com.felipe.contactlistcleanarch.usecase.contact.CreateContactUseCase;
import com.felipe.contactlistcleanarch.usecase.contact.CreateContactUseCase.Input;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
public class CreateContactController {

    private final CreateContactUseCase createContactUseCase;

    public CreateContactController(CreateContactUseCase createContactUseCase) {
        this.createContactUseCase = createContactUseCase;
    }

    @PostMapping("api/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody Request request) {
        createContactUseCase.execute(new Input(request.name(), request.phone));
    }

    public record Request(
            @NotBlank
            String name,
            @NotBlank
            String phone) {}

}
