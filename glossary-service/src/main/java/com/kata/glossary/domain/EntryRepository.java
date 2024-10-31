package com.kata.glossary.domain;

import com.kata.glossary.infrastructure.persistence.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<EntryEntity,Long> {
    Entry findByName(String name);
}
