package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ingrediente")
public class Ingrediente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CIngrediente;
	
	@Column(name = "NIngrediente", length = 50, nullable = false)
	private String NIngrediente;
	
	@Column(name = "QUnidadMedidaIngrediente")
	private Integer QUnidadMedidaIngrediente;
	
	@Column(name = "NUnidadMedidaIngrediente", length = 50, nullable = false)
	private String NUnidadMedidaIngrediente;
	
	@ManyToOne
	@JoinColumn(name = "CTipoIngrediente",nullable = false)
	private TipoIngrediente CTipoIngrediente;

	public Integer getCIngrediente() {
		return CIngrediente;
	}

	public void setCIngrediente(Integer cIngrediente) {
		CIngrediente = cIngrediente;
	}

	public String getNIngrediente() {
		return NIngrediente;
	}

	public void setNIngrediente(String nIngrediente) {
		NIngrediente = nIngrediente;
	}

	public Integer getQUnidadMedidaIngrediente() {
		return QUnidadMedidaIngrediente;
	}

	public void setQUnidadMedidaIngrediente(Integer qUnidadMedidaIngrediente) {
		QUnidadMedidaIngrediente = qUnidadMedidaIngrediente;
	}

	public String getNUnidadMedidaIngrediente() {
		return NUnidadMedidaIngrediente;
	}

	public void setNUnidadMedidaIngrediente(String nUnidadMedidaIngrediente) {
		NUnidadMedidaIngrediente = nUnidadMedidaIngrediente;
	}

	public TipoIngrediente getCTipoIngrediente() {
		return CTipoIngrediente;
	}

	public void setCTipoIngrediente(TipoIngrediente cTipoIngrediente) {
		CTipoIngrediente = cTipoIngrediente;
	}

	
	
	
}
