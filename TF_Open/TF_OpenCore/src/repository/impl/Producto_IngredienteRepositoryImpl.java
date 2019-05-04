package pe.edu.upc.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.entity.Producto_Ingrediente;
import pe.edu.upc.repository.Producto_IngredienteRepository;

@Named
public class Producto_IngredienteRepositoryImpl implements Producto_IngredienteRepository, Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TF_OpenPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Producto_Ingrediente t) throws Exception {
		em.persist(t);
		return t.getCProducto_Ingrediente();
	}

	@Override
	public Integer Update(Producto_Ingrediente t) throws Exception {
		em.merge(t);
		return t.getCProducto_Ingrediente();
	}

	@Override
	public Integer Delete(Producto_Ingrediente t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Producto_Ingrediente> FindAll() throws Exception {
		List<Producto_Ingrediente> arr_prodctingrdnt=new ArrayList<>();
		TypedQuery<Producto_Ingrediente> query=em.createQuery("SELECT pi FROM Producto_Ingrediente pi", Producto_Ingrediente.class);
		arr_prodctingrdnt=query.getResultList();
		return arr_prodctingrdnt;
	}

	@Override
	public Producto_Ingrediente FindById(Producto_Ingrediente t) throws Exception {
		List<Producto_Ingrediente> arr_prodctingrdnt=new ArrayList<>();
		TypedQuery<Producto_Ingrediente> query=em.createQuery("SELECT pi FROM Producto_Ingrediente pi WHERE CProducto_Ingrediente=?1", Producto_Ingrediente.class);
		query.setParameter(1, t.getCProducto_Ingrediente());
		arr_prodctingrdnt=query.getResultList();
		
		if(arr_prodctingrdnt!=null &&!arr_prodctingrdnt.isEmpty()) {
			return arr_prodctingrdnt.get(0);
		}
		else {
			return new Producto_Ingrediente();
		}
	}

}
