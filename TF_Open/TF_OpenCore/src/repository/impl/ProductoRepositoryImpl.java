package pe.edu.upc.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.entity.Producto;
import pe.edu.upc.repository.ProductoRepository;

@Named
public class ProductoRepositoryImpl implements ProductoRepository, Serializable{
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TF_OpenPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Producto t) throws Exception {
		em.persist(t);
		return t.getCProducto();
	}

	@Override
	public Integer Update(Producto t) throws Exception {
		em.merge(t);
		return t.getCProducto();
	}

	@Override
	public Integer Delete(Producto t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Producto> FindAll() throws Exception {
		List<Producto> productos=new ArrayList<>();
		TypedQuery<Producto> query=em.createQuery("SELECT p FROM Producto p", Producto.class);
		productos=query.getResultList();
		return productos;		
	}

	@Override
	public Producto FindById(Producto t) throws Exception {
		List<Producto> productos=new ArrayList<>();
		TypedQuery<Producto> query=em.createQuery("SELECT p FROM Producto p WHERE CProduto=?1", Producto.class);
		query.setParameter(1, t.getCProducto());
		productos=query.getResultList();
		
		if(productos!=null && !productos.isEmpty()) {
			return productos.get(0);
		}
		else {
			return new Producto();
		}

	}

}
