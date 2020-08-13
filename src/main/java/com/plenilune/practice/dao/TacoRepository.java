package com.plenilune.practice.dao;

import com.plenilune.practice.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
