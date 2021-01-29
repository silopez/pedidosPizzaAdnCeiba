package com.pedidospizza.adnceiba.infraestructura;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedidospizza.adnceiba.pizza.aplicacion.comando.PizzaComando;
import com.pedidospizza.adnceiba.testdatabuilder.pizza.PizzaComandoTestDataBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PizzaTestIntegracion {
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void crearPizzaTest() throws Exception {

        PizzaComando pizza = new PizzaComandoTestDataBuilder().build();
        mockMvc.perform( MockMvcRequestBuilders
                .post("/pizzas")
                .content(objectMapper.writeValueAsString(pizza))
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isCreated());
    }
    
    @Test
    void listarTodasPizzaTest() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
                .get("/pizzas")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
    
    @Test
    void actualizarPizzaTest() throws Exception {

        PizzaComando pizza = new PizzaComandoTestDataBuilder().build();
        mockMvc.perform( MockMvcRequestBuilders
                .put("/pizzas")
                .content(objectMapper.writeValueAsString(pizza))
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
    
    @Test
    void eliminarPizzaTest() throws Exception {
        PizzaComando pizza = new PizzaComandoTestDataBuilder().build();
        mockMvc.perform( MockMvcRequestBuilders
                .delete("/pizzas/1")
                .content(objectMapper.writeValueAsString(pizza))
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
}
