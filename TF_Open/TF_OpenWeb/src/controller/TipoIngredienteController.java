package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.entity.TipoIngrediente;
import pe.edu.upc.service.TipoIngredienteService;
import pe.edu.upc.util.Message;

@Named
@ViewScoped
public class TipoIngredienteController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoIngredienteService tpingreidenteService;
	
	private TipoIngrediente tpingrediente;
	private TipoIngrediente tpingredienteSelec;
	private List<TipoIngrediente> tpingredientes;
	
	public void loadTipoIngredientes() {
		try {			
			this.tpingredientes=tpingreidenteService.FindAll();
		}catch(Exception e) {
			Message.messageError("Error: "+e.getMessage());
		}		
	}
	
	public void resetForm() {
		this.tpingrediente=new TipoIngrediente();
		this.tpingredienteSelec=null;
	}
	
	@PostConstruct
	public void init() {
		this.tpingrediente=new TipoIngrediente();
		this.tpingredienteSelec=new TipoIngrediente();
		this.loadTipoIngredientes();
	}
	
	public void saveTipoIngrediente() {
		try {
			if(tpingrediente.getCTipoIngrediente()!=null) {
				tpingreidenteService.Update(tpingrediente);
				Message.messageInfo("UPDATE: Exitoso");
			}else {
				tpingreidenteService.Insert(tpingrediente);
				Message.messageInfo("INSERT: Exitoso");
			}
			this.loadTipoIngredientes();
			this.resetForm();
		}catch(Exception e) {
			Message.messageError("ERROR: en SAVE de TipoIngrediente");			
		}
	}
	
	public void selectTipoIngrediente(SelectEvent e) {
		this.tpingredienteSelec=(TipoIngrediente)e.getObject();
	}
	
	public void editTipoIngrediente() {
		try {
			if(this.tpingredienteSelec!=null) {
				this.tpingrediente=this.tpingredienteSelec;
			}else {
				Message.messageError("ERROR: Seleccione TipoIngrediente a editar");
			}			
		}catch(Exception e) {
			Message.messageError("ERROR: en EDIT de TipoIngrediente: "+ e.getMessage());
		}
	}

	public TipoIngrediente getTpingrediente() {
		return tpingrediente;
	}

	public void setTpingrediente(TipoIngrediente tpingrediente) {
		this.tpingrediente = tpingrediente;
	}

	public TipoIngrediente getTpingredienteSelec() {
		return tpingredienteSelec;
	}

	public void setTpingredienteSelec(TipoIngrediente tpingredienteSelec) {
		this.tpingredienteSelec = tpingredienteSelec;
	}

	public List<TipoIngrediente> getTpingredientes() {
		return tpingredientes;
	}

	public void setTpingredientes(List<TipoIngrediente> tpingredientes) {
		this.tpingredientes = tpingredientes;
	}
	
	
}
