package com.pedidospizza.adnceiba.pedido.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import com.pedidospizza.adnceiba.pedido.dominio.modelo.Pedido;
import com.pedidospizza.adnceiba.pedido.dominio.modelo.PedidoDto;
import com.pedidospizza.adnceiba.pedido.dominio.puerto.PedidoRepositorio;
import com.pedidospizza.adnceiba.utils.EstadoPedidoEnum;
import com.pedidospizza.adnceiba.utils.MensajesGeneralesEnum;
import com.pedidospizza.adnceiba.utils.excepciones.EstadoPedidoCambiarEntragadoInvalidoExcepcion;
import com.pedidospizza.adnceiba.utils.excepciones.EstadoPedidoCambiarInvalidoExcepcion;
import com.pedidospizza.adnceiba.utils.excepciones.EstadoPedidoCambiarTiempoInvalidoExcepcion;

public class ModificarEstadoPedidoServicio {

	private final PedidoRepositorio pedidoRepositorio;
	private final ConsultarPedidoServicio consultarPedidoServicio;
	
	private static final int MINUTOS_PARA_CANCELAR = 30;

    public ModificarEstadoPedidoServicio(PedidoRepositorio pedidoRepositorio, ConsultarPedidoServicio consultarPedidoServicio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.consultarPedidoServicio = consultarPedidoServicio;
    }

    public void ejecutar(Long id, EstadoPedidoEnum estadoPedido) {
    	
    	PedidoDto pedidoEncontrado = consultarPedidoServicio.getPedidoPorId(id);
    	
    	if(pedidoEncontrado != null) {
    		
    		if(EstadoPedidoEnum.CANCELADO.equals(estadoPedido)){
    			validarFechaCancelar(pedidoEncontrado.getFechaPedido());
    			validarFechaCancelarEntregado(pedidoEncontrado.getEstadoPedido());
    		}else {
    			validarEstadoPedidoCambiar(pedidoEncontrado.getEstadoPedido(), estadoPedido);
    		}
    		
    		Pedido pedidoCambiar = new Pedido(pedidoEncontrado.getId(), pedidoEncontrado.getNombre(), pedidoEncontrado.getDireccion(), pedidoEncontrado.getTotal(), estadoPedido, pedidoEncontrado.getFechaPedido());
    		
    		this.pedidoRepositorio.actualizar(pedidoCambiar);
    	}
        
    }

	private void validarFechaCancelarEntregado(EstadoPedidoEnum estadoPedidoEncontrado) {
		
		if(EstadoPedidoEnum.ENTREGADO.equals(estadoPedidoEncontrado)) {
			throw new EstadoPedidoCambiarEntragadoInvalidoExcepcion(MensajesGeneralesEnum.ESTADO_PEDIDO_CANCELADO_ENTREGADO_INVALIDO.getMensaje());
		}
	}

	private void validarFechaCancelar(Date fechaPedido) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaPedido);
		calendar.add(Calendar.MINUTE, MINUTOS_PARA_CANCELAR);
		Date fechaSalida = calendar.getTime();
		
		Date fechaActual = new Date();
		
		if(fechaSalida.compareTo(fechaActual)<0) {
			throw new EstadoPedidoCambiarTiempoInvalidoExcepcion(MensajesGeneralesEnum.ESTADO_PEDIDO_CANCELADO_TIEMPO_INVALIDO.getMensaje());
		}
		
	}

	private void validarEstadoPedidoCambiar(EstadoPedidoEnum estadoPedidoAnterior, EstadoPedidoEnum estadoPedidoActual) {
		
		if(estadoPedidoActual.getId()< estadoPedidoAnterior.getId()) {
			throw new EstadoPedidoCambiarInvalidoExcepcion(MensajesGeneralesEnum.ESTADO_PEDIDO_CAMBIAR_INVALIDO.getMensaje());
		}
		
	}
}
