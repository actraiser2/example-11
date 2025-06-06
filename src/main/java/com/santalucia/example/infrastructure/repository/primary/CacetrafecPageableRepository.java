package com.santalucia.example.infrastructure.repository.primary;

import com.santalucia.example.infrastructure.entity.Cacetrafec;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * CacetrafecRepository
 *
 */
@Repository
public interface CacetrafecPageableRepository extends ListPagingAndSortingRepository<Cacetrafec, Long> {

}
