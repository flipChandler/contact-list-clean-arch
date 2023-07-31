package com.felipe.contactlistcleanarch.infra.contact.controller;

import com.felipe.contactlistcleanarch.usecase.contact.DeleteContactUseCase;
import com.felipe.contactlistcleanarch.usecase.contact.DeleteContactUseCase.Input;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteContactController {

    private final DeleteContactUseCase deleteContactUseCase;

    public DeleteContactController(DeleteContactUseCase deleteContactUseCase) {
        this.deleteContactUseCase = deleteContactUseCase;
    }

    @DeleteMapping("api/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        deleteContactUseCase.execute(new Input(id));
    }

}
