package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoIngrediente")
public class TipoIngrediente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CTipoIngrediente;
	
	@Column(name = "NTipoIngrediente", length = 50, nullable = false)
	private String NTipoIngrediente;

	public Integer getCTipoIngrediente() {
		return CTipoIngrediente;
	}

	public void setCTipoIngrediente(Integer cTipoIngrediente) {
		CTipoIngrediente = cTipoIngrediente;
	}

	public String getNTipoIngrediente() {
		return NTipoIngrediente;
	}

	public void setNTipoIngrediente(String nTipoIngrediente) {
		NTipoIngrediente = nTipoIngrediente;
	}
	
	
}
