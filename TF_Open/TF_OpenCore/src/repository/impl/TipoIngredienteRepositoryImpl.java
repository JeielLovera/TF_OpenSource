package pe.edu.upc.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.entity.TipoIngrediente;
import pe.edu.upc.repository.TipoIngredienteRepository;

@Named
public class TipoIngredienteRepositoryImpl implements TipoIngredienteRepository, Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TF_OpenPU")
	private EntityManager em;
	
	
	@Override
	public Integer Insert(TipoIngrediente t) throws Exception {
		em.persist(t);
		return t.getCTipoIngrediente();
	}

	@Override
	public Integer Update(TipoIngrediente t) throws Exception {
		em.merge(t);
		return t.getCTipoIngrediente();
	}

	@Override
	public Integer Delete(TipoIngrediente t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<TipoIngrediente> FindAll() throws Exception {
		List<TipoIngrediente> tpingredientes=new ArrayList<>();
		TypedQuery<TipoIngrediente> query=em.createQuery("SELECT tp FROM TipoIngrediente tp", TipoIngrediente.class);
		tpingredientes=query.getResultList();
		return tpingredientes;
	}

	@Override
	public TipoIngrediente FindById(TipoIngrediente t) throws Exception {
		List<TipoIngrediente> tpingredientes=new ArrayList<>();
		TypedQuery<TipoIngrediente> query=em.createQuery("SELECT tp FROM TipoIngrediente WHERE CTipoIngrediente=?1", TipoIngrediente.class);
		query.setParameter(1, t.getCTipoIngrediente());
		tpingredientes=query.getResultList();
		
		if(tpingredientes!=null && !tpingredientes.isEmpty()) {
			return tpingredientes.get(0);
		}
		else {
			return new TipoIngrediente();
		}
			
	}

}
