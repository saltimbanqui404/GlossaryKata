package com.kata.glossary.application;

import com.kata.glossary.domain.Entry;

public interface EntryService {

    Entry findByName(String name);
}
