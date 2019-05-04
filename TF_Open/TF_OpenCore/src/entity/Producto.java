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
@Table(name = "Producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CProducto;
	
	@Column(name = "NProducto", length = 50, nullable = false)
	private String NProducto;
	
	@Column(name = "MPrecio")
	private double MPrecio;
	
	@ManyToOne
	@JoinColumn(name = "CTipoProducto", nullable = false)
	private TipoProducto CTipoProducto;

	public Integer getCProducto() {
		return CProducto;
	}

	public void setCProducto(Integer cProducto) {
		CProducto = cProducto;
	}

	public String getNProducto() {
		return NProducto;
	}

	public void setNProducto(String nProducto) {
		NProducto = nProducto;
	}

	public double getMPrecio() {
		return MPrecio;
	}

	public void setMPrecio(double mPrecio) {
		MPrecio = mPrecio;
	}

	public TipoProducto getCTipoProducto() {
		return CTipoProducto;
	}

	public void setCTipoProducto(TipoProducto cTipoProducto) {
		CTipoProducto = cTipoProducto;
	}
	
	
}
