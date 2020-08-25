package com.plenilune.tacodata;

import com.plenilune.tacodomain.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
}
