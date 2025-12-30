package com.santalucia.example.infrastructure.repository.primary;

import java.time.LocalDate;
import java.util.List;

import com.santalucia.example.infrastructure.entity.Cacetrafec;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;


/**
 * CacetrafecRepository
 *
 */
@Repository
public interface CacetrafecPageableRepository extends ListPagingAndSortingRepository<Cacetrafec, Long> {

	@Query("SELECT * FROM CACETRAFEC WHERE "
			+ "(:ccentrab IS NULL OR CCENTRAB = :ccentrab) AND "
			+ "(:xcacetra IS NULL OR XCACETRA = :xcacetra) AND "
			+ "(:finvaldt IS NULL OR FINVALDT = :finvaldt) AND "
			+ "(:ffivaldt IS NULL OR FFIVALDT = :ffivaldt) AND "
			+ "(:fregilog IS NULL OR FREGILOG = :fregilog)")
	List<Cacetrafec> findByFilters(@Param("ccentrab") Integer ccentrab,
								   @Param("xcacetra") String xcacetra,
								   @Param("finvaldt") LocalDate finvaldt,
								   @Param("ffivaldt") LocalDate ffivaldt,
								   @Param("fregilog") LocalDate fregilog);

}
