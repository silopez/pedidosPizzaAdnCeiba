package com.pedidospizza.adnceiba.testdatabuilder.pedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;

public class PedidoTestDataBuilder {

	private static final Long ID_TEST1 = 1L;
    private static final String NOMBRE_TEST1 = "Pablo Lopez";
    private static final String DIRECCION_TEST1 = "Barrio Cooperativo";
    private static final Integer TOTAL_TEST1 = 30000;
    private static final EstadoPedidoEnum ESTADO_TEST1 = EstadoPedidoEnum.RECIBIDO;
    private static final Date FECHA_PEDIDO_TEST1 = new Date();
    
    private static final Long ID_TEST2 = 2L;
    private static final String NOMBRE_TEST2 = "Pedro Lopez";
    private static final String DIRECCION_TEST2 = "Barrio Cooperativo";
    private static final Integer TOTAL_TEST2 = 40000;
    private static final EstadoPedidoEnum ESTADO_TEST2 = EstadoPedidoEnum.EN_CAMINO;
    private static final Date FECHA_PEDIDO_TEST2 = new Date();
    
    private static final String NOMBRE_NO_ALFANUMERICO = "pEDRO$%#";
    private static final String NOMBRE_TAMANIO_5O = "Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez";
    private static final String DIRECCION_TAMANIO_250 = "Pedro Lopez Pedro Lopez Pedro Lopez Pedro LPedro Lopez Pedro Lopez Pedro Lopez Pedro LPedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez Pedro Lopez";
    private static final Integer TOTAL_MINIMO = 1000;
    
    private Long id;
    private String nombre;
    private String direccion;
    private Integer total;
    private EstadoPedidoEnum estado;
    private Date fechaPedido;
    
    private List<PedidoDto> listaPedidosDto = new ArrayList<>();

    public PedidoTestDataBuilder() {
        this.id = ID_TEST1;
        this.nombre = NOMBRE_TEST1;
        this.direccion = DIRECCION_TEST1;
        this.total = TOTAL_TEST1;
        this.estado = ESTADO_TEST1;
        this.fechaPedido = FECHA_PEDIDO_TEST1;
    }


    public Pedido build() {
        return new Pedido(id, nombre, direccion, total, estado, fechaPedido);
    }
    
    public List<PedidoDto> buildAllPedido() {
    	PedidoDto pedido1 =  new PedidoDto(ID_TEST1, NOMBRE_TEST1, DIRECCION_TEST1, TOTAL_TEST1, ESTADO_TEST1, FECHA_PEDIDO_TEST1);
    	PedidoDto pedido2 =  new PedidoDto(ID_TEST2, NOMBRE_TEST2, DIRECCION_TEST2, TOTAL_TEST2, ESTADO_TEST2, FECHA_PEDIDO_TEST2);
        
    	listaPedidosDto.add(pedido1);
    	listaPedidosDto.add(pedido2);
        
        return listaPedidosDto;
    }

	public Pedido buildNulloNombre() {
		return new Pedido(id, null, direccion, total, estado, fechaPedido);		
	}

	public Pedido buildNulloDireccion() {
		return new Pedido(id, nombre, null, total, estado, fechaPedido);
	}

	public Pedido buildNulloTotal() {
		return new Pedido(id, nombre, direccion, null, estado, fechaPedido);
	}

	public Pedido buildNulloEstadoPedido() {
		return new Pedido(id, nombre, direccion, total, null, fechaPedido);
	}

	public Pedido buildNoAlfanumericoNombre() {
		return new Pedido(id, NOMBRE_NO_ALFANUMERICO, direccion, total, estado, fechaPedido);
	}

	public Pedido buildTamanioNombre() {
		return new Pedido(id, NOMBRE_TAMANIO_5O, direccion, total, estado, fechaPedido);		
	}


	public Pedido buildTamanioDireccion() {
		return new Pedido(id, nombre, DIRECCION_TAMANIO_250, total, estado, fechaPedido);
	}


	public Pedido buildValorMinimo() {
		return new Pedido(id, nombre, direccion, TOTAL_MINIMO, estado, fechaPedido);
	}
}
