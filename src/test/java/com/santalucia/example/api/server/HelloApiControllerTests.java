package com.santalucia.example.api.server;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.santalucia.arq.ams.componentes.tracing.util.XRequestIDUtils;
import com.santalucia.example.api.model.IdentidadDigitalConsultaResource;

@SpringBootTest
@AutoConfigureMockMvc
//@ContextConfiguration(classes = {HelloWorldApiController.class, WebAutoConfiguration.class, SecurityAutoConfig.class, TracerAutoConfiguration.class})
//@WebMvcTest(HelloWorldApiController.class)
class HelloApiControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private HelloWorldApiDelegate helloApiDelegate;


  @Test
  @WithMockUser(value = "user-test")
  @DisplayName("dado un nombre se espera una respuesta correcta del api securizado GET /hello/{name}")
  void given_a_name_an_ok_response_is_expected() throws Exception  {

	String xrequest = UUID.randomUUID().toString();
	 IdentidadDigitalConsultaResource resource = Instancio.create(IdentidadDigitalConsultaResource.class);

	 String[] brand = new String[] { "Toyota" };
//    when(helloApiDelegate.getHelloByName(Mockito.anyString(), Mockito.any()))
//      .thenReturn(CompletableFuture.completedFuture(ResponseEntity.ok(resource)));
//    
    when(helloApiDelegate.getHelloByName(Mockito.anyString(), Mockito.any()))
   // .thenThrow(new SantaluciaWebRuntimeException(AppErrorCodes.INVALID_NAME, brand)); OK
    // .thenThrow(new TypeMismatchException("","Toyota".getClass())); //OK
     .thenThrow(new RuntimeException("")); //KO
    
    mvc.perform(asyncDispatch(mvc.perform(get("/hello-world/v1/hello/{name}", resource.getNombre())
        .header(XRequestIDUtils.X_REQUEST_HEADER, xrequest)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)).andReturn()))
      .andExpect(status().isOk())
      .andExpect(header().stringValues(XRequestIDUtils.X_REQUEST_HEADER, xrequest))
      .andExpect(content().encoding(StandardCharsets.UTF_8))
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(jsonPath("$.nombre", is(resource.getNombre())));
  }

  @Test
  @WithAnonymousUser
  @DisplayName("dado un usuario no logado se espera un error al no haber seguridad")
  void given_no_security_an_401_response_is_expected() throws Exception {

    IdentidadDigitalConsultaResource resource = Instancio.create(IdentidadDigitalConsultaResource.class);

    when(helloApiDelegate.getHelloByName(Mockito.anyString(), Mockito.any()))
      .thenReturn(CompletableFuture.completedFuture(new ResponseEntity<>(resource, HttpStatus.OK)));

    mvc.perform(get("/hello-world/v1/hello/{name}", resource.getNombre())
        .header(XRequestIDUtils.X_REQUEST_HEADER, UUID.randomUUID())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isUnauthorized())
    .andExpect(content().encoding(StandardCharsets.UTF_8));
  }


}
