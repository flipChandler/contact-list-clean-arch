package com.felipe.contactlistcleanarch.infra.contact.controller;

import com.felipe.contactlistcleanarch.usecase.contact.GetAllContactsUseCase;
import com.felipe.contactlistcleanarch.usecase.contact.GetAllContactsUseCase.Output;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GetAllContactsController {

    private final GetAllContactsUseCase getAllContactsUseCase;

    public GetAllContactsController(GetAllContactsUseCase getAllContactsUseCase) {
        this.getAllContactsUseCase = getAllContactsUseCase;
    }

    @GetMapping("api/contacts")
    public List<Response> getAllContacts() {
        return getAllContactsUseCase.execute()
                .stream()
                .map(output -> new Response(output))
                .collect(Collectors.toList());
    }

    public record Response(Output output) {}
}
