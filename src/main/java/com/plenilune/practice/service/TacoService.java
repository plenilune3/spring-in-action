package com.plenilune.practice.service;

import com.plenilune.practice.dao.TacoRepository;
import com.plenilune.practice.domain.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TacoService {

    private final TacoRepository tacoRepository;

    @Autowired
    public TacoService(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    public Taco saveTaco(Taco design) {
        return tacoRepository.save(design);
    }
}
