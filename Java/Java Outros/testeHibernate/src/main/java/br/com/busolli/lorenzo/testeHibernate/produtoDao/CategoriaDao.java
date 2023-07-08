package br.com.busolli.lorenzo.testeHibernate.produtoDao;

import javax.persistence.EntityManager;

import br.com.busolli.lorenzo.testeHibernate.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;
	
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		em.persist(categoria);
	}
}
