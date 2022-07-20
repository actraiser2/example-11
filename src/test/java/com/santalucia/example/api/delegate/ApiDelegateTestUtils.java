package com.santalucia.example.api.delegate;

import com.santalucia.example.api.model.EmployeeResource;
import com.santalucia.example.api.model.IndicadorResource;
import com.santalucia.example.core.domain.EmployeeDomain;
import com.santalucia.example.core.domain.IndicadoresCentroDomain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ApiDelegateTestUtils {

  protected static List<EmployeeDomain> buildListEmployeeDomain() {
    return Arrays.asList(EmployeeDomain.builder().firstName("John").lastName("Doe").emailAddress("jhon@email.com").build(),
      EmployeeDomain.builder().firstName("Jane").lastName("Doe").emailAddress("jane@email.com").build(),
      EmployeeDomain.builder().firstName("Ruth").lastName("Doe").emailAddress("ruth@email.com").build());
  }

  protected static List<EmployeeResource> buildListEmployeeResource() {
    return Arrays.asList(new EmployeeResource("John", "Doe", "jhon@email.com"),
      new EmployeeResource("Jane", "Doe", "jane@email.com"),
      new EmployeeResource("Ruth", "Doe", "ruth@email.com"));
  }

  public static List<IndicadoresCentroDomain> buildIndicadoresList() {
    return Arrays.asList(IndicadoresCentroDomain.builder().ccentrab((short) 1).xcacetra("CACETRA").finvaldt(new Date()).ffivaldt(new Date()).fregilog(new Date()).build(),
      IndicadoresCentroDomain.builder().ccentrab((short) 2).xcacetra("CACETRA").finvaldt(new Date()).ffivaldt(new Date()).fregilog(new Date()).build(),
      IndicadoresCentroDomain.builder().ccentrab((short) 3).xcacetra("CACETRA").finvaldt(new Date()).ffivaldt(new Date()).fregilog(new Date()).build());
  }

  public static List<IndicadorResource> buildIndicadoresListResource() {
    return Arrays.asList(new IndicadorResource(1, "CACETRA", LocalDate.now(), LocalDate.now(), LocalDate.now()),
      new IndicadorResource(2, "CACETRA", LocalDate.now(), LocalDate.now(), LocalDate.now()),
      new IndicadorResource(3, "CACETRA", LocalDate.now(), LocalDate.now(), LocalDate.now()));
  }
}
