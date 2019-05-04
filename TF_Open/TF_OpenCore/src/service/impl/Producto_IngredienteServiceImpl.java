package pe.edu.upc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Ingrediente;
import pe.edu.upc.entity.Producto;
import pe.edu.upc.entity.Producto_Ingrediente;
import pe.edu.upc.repository.IngredienteRepository;
import pe.edu.upc.repository.ProductoRepository;
import pe.edu.upc.repository.Producto_IngredienteRepository;
import pe.edu.upc.service.Producto_IngredienteService;

@Named
public class Producto_IngredienteServiceImpl implements Producto_IngredienteService, Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Producto_IngredienteRepository prodctingrntRepo;
	@Inject
	private ProductoRepository productoRepo;
	@Inject
	private IngredienteRepository ingredienteRepo;
	
	@Transactional
	@Override
	public Integer Insert(Producto_Ingrediente t) throws Exception {
		Producto producto=productoRepo.FindById(t.getCProducto());
		t.setCProducto(producto);
		Ingrediente ingrediente=ingredienteRepo.FindById(t.getCIngrediente());
		t.setCIngrediente(ingrediente);
		return prodctingrntRepo.Insert(t);
	}

	@Transactional
	@Override
	public Integer Update(Producto_Ingrediente t) throws Exception {
		Producto producto=productoRepo.FindById(t.getCProducto());
		t.setCProducto(producto);
		Ingrediente ingrediente=ingredienteRepo.FindById(t.getCIngrediente());
		t.setCIngrediente(ingrediente);
		return prodctingrntRepo.Update(t);
	}

	@Transactional
	@Override
	public Integer Delete(Producto_Ingrediente t) throws Exception {
		return prodctingrntRepo.Delete(t);
	}

	@Override
	public List<Producto_Ingrediente> FindAll() throws Exception {
		return prodctingrntRepo.FindAll();
	}

	@Override
	public Producto_Ingrediente FindById(Producto_Ingrediente t) throws Exception {
		return prodctingrntRepo.FindById(t);
	}
	

}
