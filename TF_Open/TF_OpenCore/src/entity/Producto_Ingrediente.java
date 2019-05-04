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
@Table(name = "Producto_Ingrediente")
public class Producto_Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CProducto_Ingrediente;
	
	@ManyToOne
	@JoinColumn(name = "CProducto", nullable = false)
	private Producto CProducto;
	
	@ManyToOne
	@JoinColumn(name = "CIngrediente", nullable = false)
	private Ingrediente CIngrediente;
	
	public Ingrediente getCIngrediente() {
		return CIngrediente;
	}

	public void setCIngrediente(Ingrediente cIngrediente) {
		CIngrediente = cIngrediente;
	}

	@Column(name = "QUsadaIngrediente")
	private Integer QUsadaIngrediente;
	
	@Column(name = "NUnidadMedidaUsada", length = 50, nullable = false)
	private String NUnidadMedidaUsada;

	public Integer getCProducto_Ingrediente() {
		return CProducto_Ingrediente;
	}

	public void setCProducto_Ingrediente(Integer cProducto_Ingrediente) {
		CProducto_Ingrediente = cProducto_Ingrediente;
	}

	public Producto getCProducto() {
		return CProducto;
	}

	public void setCProducto(Producto cProducto) {
		CProducto = cProducto;
	}

	public Integer getQUsadaIngrediente() {
		return QUsadaIngrediente;
	}

	public void setQUsadaIngrediente(Integer qUsadaIngrediente) {
		QUsadaIngrediente = qUsadaIngrediente;
	}

	public String getNUnidadMedidaUsada() {
		return NUnidadMedidaUsada;
	}

	public void setNUnidadMedidaUsada(String nUnidadMedidaUsada) {
		NUnidadMedidaUsada = nUnidadMedidaUsada;
	}

	
	

}
