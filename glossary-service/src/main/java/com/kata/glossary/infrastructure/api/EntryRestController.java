package com.kata.glossary.infrastructure.api;


import com.kata.glossary.application.EntryService;
import com.kata.glossary.domain.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry")
public class EntryRestController {

   @Autowired
   EntryService entryService;

   @GetMapping("/name/{name}")
   public Entry findByName (@PathVariable String name) {
      return entryService.findByName(name);
   }

}
