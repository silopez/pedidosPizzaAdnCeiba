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
    public void crearPizzaTest() throws Exception {

        Long id = 10L;
        String nombre = "Pizza Italiana";
        String tipo = "Rica Pizza Italiana";
        Integer valor = 50000;

        PizzaComando pizzaComando = new PizzaComando(id, nombre, tipo, valor);
        mockMvc.perform( MockMvcRequestBuilders
                .post("/pizzas")
                .content(objectMapper.writeValueAsString(pizzaComando))
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void listarTodasPizzaTest() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
                .get("/pizzas")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void actualizarPizzaTest() throws Exception {
    	Long id = 1L;
        String nombre = "Pizza Italiana";
        String tipo = "Rica Pizza Italiana";
        Integer valor = 50000;

        PizzaComando pizzaComando = new PizzaComando(id, nombre, tipo, valor);
        mockMvc.perform( MockMvcRequestBuilders
                .put("/pizzas")
                .content(objectMapper.writeValueAsString(pizzaComando))
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
}
