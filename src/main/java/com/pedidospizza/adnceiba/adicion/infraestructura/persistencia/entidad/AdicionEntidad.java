package com.pedidospizza.adnceiba.adicion.infraestructura.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

@Entity(name = "adiciones")
@NamedQuery(name="Adicion.obtenerTodas" , query="SELECT ans FROM adiciones ans")
@Data
public class AdicionEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "descripcion", length = 250)
	private String descripcion;
	
	@Column(name = "valor")
	private Integer valor;	
}
