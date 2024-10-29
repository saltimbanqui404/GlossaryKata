package com.kata.glossary.application;

import com.kata.glossary.domain.AikidoRank;
import com.kata.glossary.domain.Kata;
import com.kata.glossary.domain.KataRepository;
import com.kata.glossary.infrastructure.persistence.KataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KataServiceImpl implements KataService {

    @Autowired
    private KataRepository kataRepository;


    @Override
    public void saveKata(Kata kata) {
        //Mapeo de Kata  a KataEntity
        KataEntity kataEntity = new KataEntity();
        kataEntity.setName(kata.getName());
        kataEntity.setDefinition(kata.getDefinition());
        kataEntity.setRank(kata.getRank().toString());
        kataEntity.setStepsDefinition(kata.getStepsDefinition());

        //Persistencia
        System.out.println("saving Kata in DB");
        kataRepository.save(kataEntity);
    }

    @Override
    public Kata compareKataByRank(Kata currentKata, Kata targetKata) {
        if (currentKata.getRank().getHigherOrEqualRank(targetKata.getRank()).equals(currentKata)) {
            return currentKata;
        } else {
            return targetKata;
        }
    }

    @Override
    public List<Kata> getKataByRank (String rank) {
        return kataRepository.findByRank(rank)
                .stream().map(kataEntity -> {
                    Kata kata = new Kata();
                    kata.setId(kataEntity.getId());
                    kata.setName(kataEntity.getName());
                    kata.setDefinition(kataEntity.getDefinition());
                    kata.setRank(AikidoRank.fromString(kataEntity.getRank()));
                    kata.setStepsDefinition(kataEntity.getStepsDefinition());
                    return kata;
                }).toList();
    }
}
