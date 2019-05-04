package pe.edu.upc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.model.entity.TipoProducto;
import pe.edu.upc.repository.TipoProductoRepository;
import pe.edu.upc.service.TipoProductoService;

public class TipoProductoServiceImpl implements TipoProductoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoProductoRepository tipoProductoRepo;
	
	@Transactional
	@Override
	public Integer Insert(TipoProducto t) throws Exception {
		return tipoProductoRepo.Insert(t);
	}
	@Transactional
	@Override
	public Integer Update(TipoProducto t) throws Exception {
		return tipoProductoRepo.Update(t);
	}
	@Transactional
	@Override
	public Integer Delete(TipoProducto t) throws Exception {
		return tipoProductoRepo.Delete(t);
	}
	
	@Override
	public List<TipoProducto> FindAll() throws Exception {
		return tipoProductoRepo.FindAll();
	}
	
	@Override
	public TipoProducto FindById(TipoProducto t) throws Exception {
		return tipoProductoRepo.FindById(t);
	}

}
