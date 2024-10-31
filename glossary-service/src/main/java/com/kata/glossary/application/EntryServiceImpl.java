package com.kata.glossary.application;

import com.kata.glossary.domain.Entry;
import com.kata.glossary.domain.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Entry findByName(String name) {
        return entryRepository.findByName(name);
    }
}