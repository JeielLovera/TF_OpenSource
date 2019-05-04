package pe.edu.upc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Ingrediente;
import pe.edu.upc.entity.TipoIngrediente;
import pe.edu.upc.repository.IngredienteRepository;
import pe.edu.upc.repository.TipoIngredienteRepository;
import pe.edu.upc.service.IngredienteService;



@Named
public class IngredienteServiceImpl implements IngredienteService, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoIngredienteRepository tipoIngredienteRepo;
	@Inject
	private IngredienteRepository ingreRepo;
	
	@Transactional
	@Override
	public Integer Insert(Ingrediente t) throws Exception {
		TipoIngrediente tpingrediente=tipoIngredienteRepo.FindById(t.getCTipoIngrediente());
		t.setCTipoIngrediente(tpingrediente);
		return ingreRepo.Insert(t);
	}
	
	@Transactional
	@Override
	public Integer Update(Ingrediente t) throws Exception {
		TipoIngrediente tpingrediente=tipoIngredienteRepo.FindById(t.getCTipoIngrediente());
		t.setCTipoIngrediente(tpingrediente);
		return ingreRepo.Update(t);
	}
	
	@Transactional
	@Override
	public Integer Delete(Ingrediente t) throws Exception {
		TipoIngrediente tpingrediente=tipoIngredienteRepo.FindById(t.getCTipoIngrediente());
		t.setCTipoIngrediente(tpingrediente);
		return ingreRepo.Delete(t);
	}

	@Override
	public List<Ingrediente> FindAll() throws Exception {
		return ingreRepo.FindAll();
	}

	@Override
	public Ingrediente FindById(Ingrediente t) throws Exception {
		return ingreRepo.FindById(t);
	}

}
