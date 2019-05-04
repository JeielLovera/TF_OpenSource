package pe.edu.upc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.entity.TipoIngrediente;
import pe.edu.upc.repository.TipoIngredienteRepository;
import pe.edu.upc.service.TipoIngredienteService;

@Named
public class TipoIngredienteServiceImpl implements TipoIngredienteService, Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private TipoIngredienteRepository tpingredienteRepo;
	
	@Transactional
	@Override
	public Integer Insert(TipoIngrediente t) throws Exception {
		return tpingredienteRepo.Insert(t);
	}
	
	@Transactional
	@Override
	public Integer Update(TipoIngrediente t) throws Exception {
		return tpingredienteRepo.Update(t);
	}

	@Transactional
	@Override
	public Integer Delete(TipoIngrediente t) throws Exception {
		return tpingredienteRepo.Delete(t);
	}

	@Override
	public List<TipoIngrediente> FindAll() throws Exception {
		return tpingredienteRepo.FindAll();
	}

	@Override
	public TipoIngrediente FindById(TipoIngrediente t) throws Exception {
		return tpingredienteRepo.FindById(t);
	}

}
