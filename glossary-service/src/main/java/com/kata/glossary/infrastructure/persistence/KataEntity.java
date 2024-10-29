package com.kata.glossary.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// KataEntity - movement sequence
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "kata")
public class KataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String definition;
    private String rank;
    private List<String> stepsDefinition;

}