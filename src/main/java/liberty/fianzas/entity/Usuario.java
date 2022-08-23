package liberty.fianzas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import io.swagger.annotations.*;
@Getter
@Setter
@ApiModel(description = "Tabla que almacena a los Usuarios")
@Entity
@Table(name="Usuario")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@ApiModelProperty(value = "Campo que contiene el identificador"
			+ "unico del Usuario")
	private Integer id;
	
	@Column
	@ApiModelProperty(value = "Campo que contiene el nombre del Usuario")
	private String nombre;
	
	@Column
	@ApiModelProperty(value = "Campo que contiene el email del Usuario")
	private String email;
	
	@Column
	@ApiModelProperty(value = "Campo que contiene el genero del Usuario")
	private String gender;
	
	@Column
	@ApiModelProperty(value = "Campo que contiene el estatus del Usuario 200 para activo 500 para inactivo")
	private Integer estatus;
	
	@Column
	@ApiModelProperty(value = "Campo que guarda la cadena de bytes que forman  la imagen")
	private byte[] foto;
	
	
}
