package com.pedidospizza.adnceiba.testdatabuilder.pedido;

import java.util.Date;

import com.pedidospizza.adnceiba.pedido.aplicacion.comando.PedidoComando;
import com.pedidospizza.adnceiba.pedido.dominio.enums.EstadoPedidoEnum;

public class PedidoComandoTestDataBuilder {
	private static final Long ID_TEST1 = 1L;
    private static final String NOMBRE_TEST1 = "Persona Lopez";
    private static final String DIRECCION_TEST1 = "Barrio Cooperativo";
    private static final Integer TOTAL_TEST1 = 40000;
    private static final EstadoPedidoEnum ESTADO_TEST1 = EstadoPedidoEnum.RECIBIDO;
    private static final Date FECHA_PEDIDO_TEST1 = new Date();  
    
    private Long id;
    private String nombre;
    private String direccion;
    private Integer total;
    private EstadoPedidoEnum estado;
    private Date fechaPedido;

    public PedidoComandoTestDataBuilder() {
        this.id = ID_TEST1;
        this.nombre = NOMBRE_TEST1;
        this.direccion = DIRECCION_TEST1;
        this.total = TOTAL_TEST1;
        this.estado = ESTADO_TEST1;
        this.fechaPedido = FECHA_PEDIDO_TEST1;
    }


    public PedidoComando build() {
        return new PedidoComando(id, nombre, direccion, total, estado, fechaPedido);
    }
    
}
