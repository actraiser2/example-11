package com.santalucia.example.core.domain;

import lombok.Builder;
import lombok.Data;


/**
 * EmployeeDomain
 *
 */
@Data
@Builder
public class EmployeeDomain {

	private String firstName;
	private String lastName;
	private String emailAddress;
}
