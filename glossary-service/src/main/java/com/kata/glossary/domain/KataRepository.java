package com.kata.glossary.domain;

import com.kata.glossary.infrastructure.persistence.KataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KataRepository extends JpaRepository<KataEntity,Long> {

    List<KataEntity> findByRank(String aikidoRank);



}
