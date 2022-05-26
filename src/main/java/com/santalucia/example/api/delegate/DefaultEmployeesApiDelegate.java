package com.santalucia.example.api.delegate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.api.server.EmployeesApiDelegate;
import com.santalucia.example.core.mappers.EmployeeDomainMapper;
import com.santalucia.example.core.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultEmployeesApiDelegate implements EmployeesApiDelegate {

	private final EmployeeService employeeService;
	private final EmployeeDomainMapper employeeMapper;

    /**
     * constructor de clase
     *
     * @param EmployeeService employeeService
     * @param EmployeeDomainMapper employeeMapper
     */
	public DefaultEmployeesApiDelegate(EmployeeService employeeService, EmployeeDomainMapper employeeMapper) {
		this.employeeService = employeeService;
		this.employeeMapper = employeeMapper;
	}

    /**
     * recupera la lista de empleados
     *
     * @param Optional<UUID> xRequestId
     * @param Pageable pageable
     * @return ResponseEntity<List<EmployeeResource>>
     */
	@Override
	public ResponseEntity<List<EmployeeResource>> getEmployeesList(Optional<UUID> xRequestId, Pageable pageable) {
		log.info("Pageable pagenumber: {} ", pageable.getPageNumber());
		log.info("Pageable pageSize: {} ", pageable.getPageSize());
		log.info("Pageable offset: {} ", pageable.getOffset());

		Resource resource = null;
		ContentDisposition.builder("attachment")
        .filename(resource.getFilename())
        .build().toString();
        
		return Optional
				.ofNullable(employeeService.getEmployees(pageable))
				.map(employees -> ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.builder("attachment")
						        .filename(resource.getFilename())
						        .build().toString())
						.contentType(MediaType.parseMediaType("text/csv"))
						.body(employeeMapper.toResources(employees))) // 200 OK
				.orElse(ResponseEntity.notFound().build()); // 404 Not found
	}
}
