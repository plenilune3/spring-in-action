package com.plenilune.tacodata;

import com.plenilune.tacodomain.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
}
