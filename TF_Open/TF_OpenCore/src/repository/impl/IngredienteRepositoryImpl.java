package pe.edu.upc.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.entity.Ingrediente;
import pe.edu.upc.repository.IngredienteRepository;

@Named
public class IngredienteRepositoryImpl implements IngredienteRepository, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TF_OpenPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Ingrediente t) throws Exception {
		em.persist(t);
		return t.getCIngrediente();
	}

	@Override
	public Integer Update(Ingrediente t) throws Exception {
		em.merge(t);
		return t.getCIngrediente();
	}

	@Override
	public Integer Delete(Ingrediente t) throws Exception {
		em.remove(t);
		return t.getCIngrediente();
	}

	@Override
	public List<Ingrediente> FindAll() throws Exception {
		
		List<Ingrediente> ingredientes= new ArrayList<>();
		TypedQuery<Ingrediente> query=em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class);
		ingredientes=query.getResultList();
		return ingredientes;
	}

	@Override
	public Ingrediente FindById(Ingrediente t) throws Exception {
		
		List<Ingrediente> ingredientes= new ArrayList<>();
		TypedQuery<Ingrediente> query=em.createQuery("SELECT i FROM Ingrediente i WHERE CIngrediente=?1", Ingrediente.class);
		query.setParameter(1, t.getCIngrediente());
		ingredientes=query.getResultList();
		if(ingredientes !=null && !ingredientes.isEmpty()){
			return ingredientes.get(0);
		}
		else {
			return new Ingrediente();
		}
	}

}
