package pe.com.integracion.dummy.dummyintegration.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Log_Values")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogValuesEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_log")
	private Long idLog;
		
	@Column(name="estado_mensaje")
	private Boolean estadoMensaje;
	
	@Column(name="codigo_mensaje")
	private String codigoMensaje;

}
