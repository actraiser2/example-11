package com.santalucia.example.api.delegate;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class DefaultIndicadoresApiDelegateTests {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetIndicadoresList() throws Exception {
        mockMvc.perform(get("/hello-world/v1/indicadores/list").
        		accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(Matchers.greaterThan(3))))
                .andExpect(jsonPath("$[0].ccentrab", is(965)))
                .andExpect(jsonPath("$[0].xcacetra", is("I")))
                .andExpect(jsonPath("$[0].finvaldt", is("2005-04-01")))
                .andExpect(jsonPath("$[0].ffivaldt", is("9999-12-31")))
                .andExpect(jsonPath("$[0].fregilog", is("2005-04-28")))
                .andExpect(jsonPath("$[1].ccentrab", is(970)))
                .andExpect(jsonPath("$[1].xcacetra", is("I")))
                .andExpect(jsonPath("$[1].finvaldt", is("2005-04-01")))
                .andExpect(jsonPath("$[1].ffivaldt", is("9999-12-31")))
                .andExpect(jsonPath("$[1].fregilog", is("2005-04-28")))
                .andExpect(jsonPath("$[2].ccentrab", is(975)))
                .andExpect(jsonPath("$[2].xcacetra", is("I")))
                .andExpect(jsonPath("$[2].finvaldt", is("2005-05-01")))
                .andExpect(jsonPath("$[2].ffivaldt", is("9999-12-31")))
                .andExpect(jsonPath("$[2].fregilog", is("2005-04-28")));
    }
}