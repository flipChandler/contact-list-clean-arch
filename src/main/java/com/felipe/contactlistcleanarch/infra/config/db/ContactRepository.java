package com.felipe.contactlistcleanarch.infra.config.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactSchema, Long> {

    @Query("SELECT c FROM ContactSchema c WHERE c.name LIKE CONCAT('%', ?1, '%')")
    List<ContactSchema> searchByNameContaining(String name);
}
