package pe.edu.upc.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoProducto")
public class TipoProducto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CTipoProducto;
	@Column(name="NTipoProducto", length=50, nullable=false)
	private String NTipoProducto;
	public Integer getCTipoProducto() {
		return CTipoProducto;
	}
	public void setCTipoProducto(Integer cTipoProducto) {
		CTipoProducto = cTipoProducto;
	}
	public String getNTipoProducto() {
		return NTipoProducto;
	}
	public void setNTipoProducto(String nTipoProducto) {
		NTipoProducto = nTipoProducto;
	}	
}
