package br.com.loja.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.loja.model.Categoria;
import br.com.loja.model.Usuario;
import br.com.olimposistema.aipa.dao.DAO;

@RequestScoped
public class CategoriaDAO extends DAO<Categoria>{
	
	@Deprecated public CategoriaDAO() {
		super(null, null);
	}
	
	@Inject
	public CategoriaDAO(EntityManager em) {
		super(em, Categoria.class);
	}
	
	
}
