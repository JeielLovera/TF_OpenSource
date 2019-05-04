package pe.edu.upc.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.TipoProducto;
import pe.edu.upc.repository.TipoProductoRepository;

@Named
public class TipoProductoRepositoryImpl implements TipoProductoRepository, Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TF_OpenPU")
	private EntityManager em;
	@Override
	public Integer Insert(TipoProducto t) throws Exception {
		em.persist(t);
		return t.getCTipoProducto();
	}

	@Override
	public Integer Update(TipoProducto t) throws Exception {
		em.merge(t);
		return t.getCTipoProducto();
	}

	@Override
	public Integer Delete(TipoProducto t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<TipoProducto> FindAll() throws Exception {
		List<TipoProducto> tipos= new ArrayList();
		TypedQuery<TipoProducto> query=em.createQuery("SELECT tp FROM TipoProducto tp", TipoProducto.class);
		tipos=query.getResultList();
		
		return tipos;
		
	}

	@Override
	public TipoProducto FindById(TipoProducto t) throws Exception {
		List<TipoProducto> tipos= new ArrayList();
		TypedQuery<TipoProducto> query=em.createQuery("SELECT tp FROM TipoProducto tp WHERE tp.CTipoProducto=?1", TipoProducto.class);
		query.setParameter(1, t.getCTipoProducto());
		tipos=query.getResultList();
		if(tipos !=null && !tipos.isEmpty()){
			return tipos.get(0);
		}
		else {
			return new TipoProducto();
		}
	}

}
