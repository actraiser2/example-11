package com.santalucia.example.api.server;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;


@WebMvcTest(HelloApiController.class)
class HelloApiControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private HelloApiDelegate helloApiDelegate;
	
    @Test
    @WithMockUser(value = "user-test")
    @DisplayName("dado un nombre se espera una respuesta correcta del api securizado GET /hello/{name}")
    void getHello_ok() throws Exception  {
    	 	    	  	 			
    	String nombre = "mock-response";
    	IdentidadDigitalConsultaResource response = buildIdentidadDigitalConsultaResource(nombre);
    	
    	when(helloApiDelegate.getHelloByName(Mockito.anyString(),Mockito.any()))
    	.thenReturn(new ResponseEntity<>(response, HttpStatus.OK));
    	
        
        mvc.perform(get("/hello-world/v1/hello/{name}",nombre)
        		.header("X-Request-ID", UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
		        .andExpect(jsonPath("$.nombre", is(nombre)));
    }
    
    @Test
    @DisplayName("dado un nombre se espera un error al no haber seguridad")
    void getHello_no_security_ko() throws Exception  {
    	
    	String nombre = "mock-response";
    	IdentidadDigitalConsultaResource response = buildIdentidadDigitalConsultaResource(nombre);
    	
    	when(helloApiDelegate.getHelloByName(Mockito.anyString(),Mockito.any()))
    	.thenReturn(new ResponseEntity<>(response, HttpStatus.OK));
    	
        
        mvc.perform(get("/hello-world/v1/hello/{name}",nombre)
        		.header("X-Request-ID", UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().is4xxClientError());
    }
    
    private IdentidadDigitalConsultaResource buildIdentidadDigitalConsultaResource(String nombre) {
    	IdentidadDigitalConsultaResource response = new IdentidadDigitalConsultaResource();
    	response.setNombre(nombre);
    	return response;
    }


}
