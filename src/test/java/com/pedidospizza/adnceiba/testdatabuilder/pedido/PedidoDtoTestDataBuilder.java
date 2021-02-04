package com.pedidospizza.adnceiba.testdatabuilder.pedido;

import java.util.Date;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;

public class PedidoDtoTestDataBuilder {

	private static final Long ID_TEST1 = 2L;
    private static final String NOMBRE_TEST1 = "Persona Lopez";
    private static final String DIRECCION_TEST1 = "Barrio Cooperativo";
    private static final Integer TOTAL_TEST1 = 40000;
    private static final EstadoPedidoEnum ESTADO_TEST1 = EstadoPedidoEnum.RECIBIDO;
    private static final Date FECHA_PEDIDO_TEST1 = new Date();
    
    private static final EstadoPedidoEnum ESTADO_TEST2 = EstadoPedidoEnum.ENTREGADO;
    private static final Date FECHA_CADUCADA = new Date(1612413609);
    
    
    private Long id;
    private String nombre;
    private String direccion;
    private Integer total;
    private EstadoPedidoEnum estado;
    private Date fechaPedido;

    public PedidoDtoTestDataBuilder() {
        this.id = ID_TEST1;
        this.nombre = NOMBRE_TEST1;
        this.direccion = DIRECCION_TEST1;
        this.total = TOTAL_TEST1;
        this.estado = ESTADO_TEST1;
        this.fechaPedido = FECHA_PEDIDO_TEST1;
    }


    public PedidoDto build() {
        return new PedidoDto(id, nombre, direccion, total, estado, fechaPedido);
    }
    
    public PedidoDto buildEstadoEntregado() {
        return new PedidoDto(id, nombre, direccion, total, ESTADO_TEST2, fechaPedido);
    }
    
    public PedidoDto buildFechaCaducada() {
        return new PedidoDto(id, nombre, direccion, total, estado, FECHA_CADUCADA);
    }
}
