package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.model.entity.TipoProducto;
import pe.edu.upc.service.TipoProductoService;
import pe.edu.upc.util.Message;

@Named
@ViewScoped
public class TipoProductoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoProductoService tipoproductoService;

	private TipoProducto tipoproducto;
	private TipoProducto tipoproductoSelec;
	private List<TipoProducto> tipos;
	
	public void loadTipos()	{
		try {
			this.tipoproductoService.FindAll();
		}catch(Exception e){
			Message.messageError("Error: "+ e.getMessage());
		}
	}
	
	public void resetForm() {
		this.tipoproducto= new TipoProducto();
		this.tipoproductoSelec= null;
	}
	
	@PostConstruct
	public void init(){
		this.tipoproducto= new TipoProducto();
		this.tipoproductoSelec= new TipoProducto();
		this.loadTipos();		
	}
	
	public void saveTipoProducto() {
		try {
			if(tipoproducto.getCTipoProducto() != null){
				tipoproductoService.Update(tipoproducto);
				Message.messageInfo("Update: Exitoso");
			} else {
				tipoproductoService.Insert(tipoproducto);
				Message.messageInfo("Insert: Exitoso");
			}
			this.loadTipos();
			this.resetForm();
		} catch(Exception e) {
			Message.messageError("Error en SAVE de Tipo Producto "+ e.getMessage());
		}			
	}
	
	public void selectTipoProducto(SelectEvent e) {
		this.tipoproductoSelec = (TipoProducto)e.getObject();
	}
	
	public void editTipoProdcuto() {
		try {
			if( this.tipoproductoSelec != null ){
				 this.tipoproducto = this.tipoproductoSelec;
			} else {
				Message.messageError("ERROR: Seleccione Tipo Producto a editar");
			}
			
		} catch(Exception e) {
			Message.messageError("Error en EDIT de Tipo Producto "+ e.getMessage());
		}		
	}

	public TipoProducto getTipoproducto() {
		return tipoproducto;
	}

	public void setTipoproducto(TipoProducto tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public TipoProducto getTipoproductoSelec() {
		return tipoproductoSelec;
	}

	public void setTipoproductoSelec(TipoProducto tipoproductoSelec) {
		this.tipoproductoSelec = tipoproductoSelec;
	}

	public List<TipoProducto> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoProducto> tipos) {
		this.tipos = tipos;
	}
	
	
}
