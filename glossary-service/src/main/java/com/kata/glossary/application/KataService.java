package com.kata.glossary.application;

import com.kata.glossary.domain.Kata;

import java.util.List;

public interface KataService {

    List<Kata> getKataByRank(String rank); //exam includes all the katas rank

    void saveKata(Kata kata);

    Kata compareKataByRank(Kata currentKata,Kata targetKata);

}
