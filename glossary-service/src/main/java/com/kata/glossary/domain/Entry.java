package com.kata.glossary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {

    private long id;
    private String name;
    private String definition;

}
