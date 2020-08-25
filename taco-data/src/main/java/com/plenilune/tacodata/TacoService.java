package com.plenilune.tacodata;

import com.plenilune.tacodomain.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TacoService {
    private final TacoRepository tacoRepository;

    public TacoService(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());

        return tacoRepository.findAll(page).getContent();
    }


    public Taco save(Taco taco) {
        return tacoRepository.save(taco);
    }

    public Optional<Taco> findById(Long id) {
        return tacoRepository.findById(id);
    }
}
