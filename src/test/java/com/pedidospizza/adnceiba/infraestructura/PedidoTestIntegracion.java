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
import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePedidoComando;
import com.pedidospizza.adnceiba.testdatabuilder.pedido.DetallePedidoComandoTestDataBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PedidoTestIntegracion {

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
    public void crearPedidoTest() throws Exception {

    	DetallePedidoComando detallePedidoComando = new DetallePedidoComandoTestDataBuilder().build();
        //PedidoComando pedidoComando = new PedidoComandoTestDataBuilder().build();
        mockMvc.perform( MockMvcRequestBuilders
                .post("/pedidos")
                .content(objectMapper.writeValueAsString(detallePedidoComando))
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void listarTodasPedidoTest() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
                .get("/pedidos")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void actualizarEstadoTest() throws Exception {
    	mockMvc.perform( MockMvcRequestBuilders
                .put("/pedidos/1/ENTREGADO")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
}
