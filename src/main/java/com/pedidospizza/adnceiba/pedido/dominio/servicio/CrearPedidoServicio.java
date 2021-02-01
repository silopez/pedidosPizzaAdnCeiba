package com.pedidospizza.adnceiba.pedido.dominio.servicio;

import java.util.Iterator;

import com.pedidospizza.adnceiba.adicion.aplicacion.comando.AdicionComando;
import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePedidoComando;
import com.pedidospizza.adnceiba.pedido.aplicacion.comando.DetallePizzaComando;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;
import com.pedidospizza.adnceiba.utils.excepciones.CantidadInvalidaAdicionEnPizzaExcepcion;
import com.pedidospizza.adnceiba.utils.excepciones.CantidadInvalidaPizzaEnPedidoExcepcion;
import com.pedidospizza.adnceiba.utils.excepciones.NoExistenPizzaEnPedidoExcepcion;

public class CrearPedidoServicio {
	
	private final PedidoRepositorio pedidoRepositorio;

    public CrearPedidoServicio(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido crear(Pedido pedido, DetallePedidoComando detallePedidoComando) {
    	
    	if(detallePedidoComando.getDetallePizzasComando().isEmpty()) {
    		throw new NoExistenPizzaEnPedidoExcepcion(MensajesGeneralesEnum.NO_EXISTE_PIZZA_PEDIDO.getMensaje());
    	}
    	
    	if(detallePedidoComando.getDetallePizzasComando().size() > 5) {
    		throw new CantidadInvalidaPizzaEnPedidoExcepcion(MensajesGeneralesEnum.CANTIDAD_INVALIDAD_PIZZA_PEDIDO.getMensaje());
    	}
    	
    	int totalPedido = 0;
    	
    	for (DetallePizzaComando detallePizzaC : detallePedidoComando.getDetallePizzasComando()) {
			if(detallePizzaC.getListaAdicionesComando().size()>3) {
				throw new CantidadInvalidaAdicionEnPizzaExcepcion(MensajesGeneralesEnum.CANTIDAD_INVALIDADO_ADICION_PIZZA.getMensaje()+ detallePizzaC.getPizzaComando().getNombre());
			}
			
			totalPedido = totalPedido + detallePizzaC.getPizzaComando().getValor();
			
			for(AdicionComando adicionC : detallePizzaC.getListaAdicionesComando()) {
				totalPedido = totalPedido + adicionC.getValor();
			}
		}
    	
    	
    	
    	
        return this.pedidoRepositorio.crear(pedido);
    }
}
