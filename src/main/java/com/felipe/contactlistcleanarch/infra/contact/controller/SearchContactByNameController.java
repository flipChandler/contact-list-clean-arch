package com.felipe.contactlistcleanarch.infra.contact.controller;

import com.felipe.contactlistcleanarch.usecase.contact.SearchContactByNameUseCase;
import com.felipe.contactlistcleanarch.usecase.contact.SearchContactByNameUseCase.Input;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchContactByNameController {

    private final SearchContactByNameUseCase searchContactByNameUseCase;

    public SearchContactByNameController(SearchContactByNameUseCase searchContactByNameUseCase) {
        this.searchContactByNameUseCase = searchContactByNameUseCase;
    }

    @GetMapping("api/contacts/search-by-name")
    public List<SearchContactByNameUseCase.Output> searchContactByName(@RequestParam(required = false) String name) {
        return searchContactByNameUseCase.execute(new Input(name));
    }

}
