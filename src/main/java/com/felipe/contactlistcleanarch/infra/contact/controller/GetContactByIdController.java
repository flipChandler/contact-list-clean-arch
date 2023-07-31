package com.felipe.contactlistcleanarch.infra.contact.controller;

import com.felipe.contactlistcleanarch.entity.contact.model.Contact;
import com.felipe.contactlistcleanarch.usecase.contact.GetContactByIdUseCase;
import com.felipe.contactlistcleanarch.usecase.contact.GetContactByIdUseCase.Input;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetContactByIdController {

    private final GetContactByIdUseCase getContactByIdUseCase;

    public GetContactByIdController(GetContactByIdUseCase getContactByIdUseCase) {
        this.getContactByIdUseCase = getContactByIdUseCase;
    }

    @GetMapping("api/contacts/{id}")
    public Response getContactById(@PathVariable Long id) {
        var output = getContactByIdUseCase.execute(new Input(id));
        return new Response(output.contact());
    }

    public record Response(Contact contact) {}

}
