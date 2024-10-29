package com.kata.glossary.infrastructure.api;


import com.kata.glossary.application.KataService;
import com.kata.glossary.domain.AikidoRank;
import com.kata.glossary.domain.Kata;
import com.kata.glossary.infrastructure.persistence.KataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/kata")
public class KataRestController {

    @Autowired
    private KataService kataService;

    @GetMapping("/{details}")
    public Map<String,Object> details() {

       Map<String,Object> body = new HashMap<>();
       body.put("title","hola");
       body.put("name","saltim");
       body.put("lastname","banqui");

       return body;
    }

    private List<KataEntity> katasTest = new ArrayList<>(Arrays.asList(
            new KataEntity(2,"kokyunage","tecnica de aikido dificil","FIRST_KYU", Arrays.asList("1.coger codo","2.controlar")),
            new KataEntity(3,"tsuki","tecnica de aikido dificil","FIRST_KYU", Arrays.asList("1.coger codo","2.controlar"))
        )
    );

    private List<Kata> katasRT = new ArrayList<>(Arrays.asList(
            new Kata(4,"ushirotsukik","k-tecnica de aikido dificil",AikidoRank.FIRST_KYU, Arrays.asList("1.coger codo","2.controlar")),
            new Kata(5,"chokutsukik","k-tecnica de aikido dificil",AikidoRank.SECOND_DAN, Arrays.asList("1.coger codo","2.controlar"))
        )
    );

    @PostMapping("/new")
    public ResponseEntity<?> createKata (@RequestBody Kata kata) {
//        katasRT.add(kata);
        kataService.saveKata(kata);
        return ResponseEntity.ok(kata);
    }

    @GetMapping("/list")
    public List<KataEntity> getKatasTest () {
        return katasTest;
    }

    @GetMapping("/rank/{rank}")
    public ResponseEntity<Kata> getKata(@PathVariable String rank) {
        System.out.println(rank);
        return kataService.getKataByRank(rank).stream()
                .filter(kata -> kata.getRank().equals(AikidoRank.valueOf(rank)))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Mensaje"));
    }

    @PutMapping("/rank/easy")
    public ResponseEntity<Kata> getMoreEasyKata (@RequestBody List<Kata> currentKatas) throws Exception {
        //recibiremos una lista de las katas que sean en json y te dira cual es la
        //kata mas dificil por nivel de rangos
        return currentKatas.stream()
                .filter(kata -> kata.getRank()!=null)
                .sorted(Comparator.comparing(Kata::getRank))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró un listado valido"));
        // mirando excepciones -> https://www.baeldung.com/exception-handling-for-rest-with-spring
    }
}
