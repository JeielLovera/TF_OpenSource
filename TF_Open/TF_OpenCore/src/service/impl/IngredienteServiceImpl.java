package pe.edu.upc.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.model.entity.Ingrediente;
import pe.edu.repository.TipoProductoRepository;
import pe.edu.upc.repository.impl.IngredienteRepository;
import pe.edu.upc.service.IIngredienteService;


@Named
public class IngredienteService implements IIngredienteService{
	@Inject
	private TipoProductoRepository tipoProductoRepo;
	private IngredienteRepository ingreRepo;
	@Override
	public Integer Insert(Ingrediente t) throws Exception {
		ingreRepo.Insert(t);
		return t.getCIngrediente();
	}
	@Transactional
	@Override
	public Integer Update(Ingrediente t) throws Exception {
		ingreRepo.Update(t);
		return t.getCIngrediente();
	}
	@Transactional
	@Override
	public Integer Delete(Ingrediente t) throws Exception {
		ingreRepo.Delete(t);
		return 1;
	}
	@Transactional
	@Override
	public List<Ingrediente> FindAll() throws Exception {
		return ingreRepo.FindAll();
	}
	@Transactional
	@Override
	public Ingrediente FindById(Ingrediente t) throws Exception {
		return ingreRepo.FindById(t);
	}

}
