package com.pedidospizza.adnceiba.testdatabuilder.pedido;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;

public class PedidoTestDataBuilder {

	private static final Long ID_TEST1 = 1L;
    private static final String NOMBRE_TEST1 = "Silvio Lopez";
    private static final String DIRECCION_TEST1 = "Barrio Cooperativo";
    private static final Integer TOTAL_TEST1 = 40000;
    private static final String ESTADO_TEST1 = "ENTREGADO";
    
    private static final Long ID_TEST2 = 2L;
    private static final String NOMBRE_TEST2 = "Pedro Lopez";
    private static final String DIRECCION_TEST2 = "Barrio Cooperativo";
    private static final Integer TOTAL_TEST2 = 40000;
    private static final String ESTADO_TEST2 = "ENTREGADO";
    
    private Long id;
    private String nombre;
    private String direccion;
    private Integer total;
    private String estado;
    
    private List<PedidoDto> listaPedidosDto = new ArrayList<>();

    public PedidoTestDataBuilder() {
        this.id = ID_TEST1;
        this.nombre = NOMBRE_TEST1;
        this.direccion = DIRECCION_TEST1;
        this.total = TOTAL_TEST1;
        this.estado = ESTADO_TEST1;
    }


    public Pedido build() {
        return new Pedido(id, nombre, direccion, total, estado);
    }
    
    public List<PedidoDto> buildAllPedido() {
    	PedidoDto pedido1 =  new PedidoDto(ID_TEST1, NOMBRE_TEST1, DIRECCION_TEST1, TOTAL_TEST1, ESTADO_TEST1);
    	PedidoDto pedido2 =  new PedidoDto(ID_TEST2, NOMBRE_TEST2, DIRECCION_TEST2, TOTAL_TEST2, ESTADO_TEST2);
        
    	listaPedidosDto.add(pedido1);
    	listaPedidosDto.add(pedido2);
        
        return listaPedidosDto;
    }
}
