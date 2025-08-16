package com.santalucia.example.infrastructure.repository.primary;

import java.util.List;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.santalucia.example.core.domain.AccuinsfluDomain;

@Repository
public interface AccuinsfluRepository extends ListPagingAndSortingRepository<AccuinsfluDomain, String>{

	public List<AccuinsfluDomain> findByNidinflu(String nidinflu);
	
}
