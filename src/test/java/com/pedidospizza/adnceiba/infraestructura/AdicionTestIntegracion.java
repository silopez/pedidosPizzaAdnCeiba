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
import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AdicionTestIntegracion {

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
    public void crearAdicionTest() throws Exception {

        Long id = 10L;
        String nombre = "Arequipe";
        String descripcion = "Dulce arequipe";
        Integer valor = 5000;

        AdicionComando adicionComando = new AdicionComando(id, nombre, descripcion, valor);
        mockMvc.perform( MockMvcRequestBuilders
                .post("/adicion/crear")
                .content(objectMapper.writeValueAsString(adicionComando))
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void listarTodasAdicionTest() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
                .get("/adicion/listarTodas")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
}