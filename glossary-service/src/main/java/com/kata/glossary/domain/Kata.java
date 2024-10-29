package com.kata.glossary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kata {

    private long id;
    private String name;
    private String definition;
    private AikidoRank rank;
    private List<String> stepsDefinition;


}
