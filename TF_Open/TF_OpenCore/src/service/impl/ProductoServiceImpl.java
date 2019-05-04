package pe.edu.upc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Producto;
import pe.edu.upc.entity.TipoProducto;
import pe.edu.upc.repository.ProductoRepository;
import pe.edu.upc.repository.TipoProductoRepository;
import pe.edu.upc.service.ProductoService;

@Named
public class ProductoServiceImpl implements ProductoService, Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProductoRepository productoRepo;
	@Inject
	private TipoProductoRepository tpproductoRepo; 
	
	@Transactional
	@Override
	public Integer Insert(Producto t) throws Exception {
		TipoProducto tpproducto=tpproductoRepo.FindById(t.getCTipoProducto());
		t.setCTipoProducto(tpproducto);
		return productoRepo.Insert(t);
		
	}

	@Transactional
	@Override
	public Integer Update(Producto t) throws Exception {
		TipoProducto tpproducto=tpproductoRepo.FindById(t.getCTipoProducto());
		t.setCTipoProducto(tpproducto);
		return productoRepo.Update(t);
	}

	@Transactional
	@Override
	public Integer Delete(Producto t) throws Exception {
		return productoRepo.Delete(t);
	}

	@Override
	public List<Producto> FindAll() throws Exception {
		return productoRepo.FindAll();
	}

	@Override
	public Producto FindById(Producto t) throws Exception {
		return productoRepo.FindById(t);
	}

}
