package br.com.busolli.lorenzo.testeHibernate.produtoDao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.busolli.lorenzo.testeHibernate.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;
	
	
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	
	
	public void cadastrar(Produto produto) {
		em.persist(produto);
	}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}
	
	public void remover(Produto produto) {
		this.em.merge(produto);
		em.remove(produto);
	}
	
	public Produto buscarPorId(long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		String queryJpql = "SELECT P FROM Produto P";
		return em.createNamedQuery("Produto.buscarTodos", Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome) {
		String queryJpql = "SELECT P FROM Produto P WHERE P.nome = :nome";
		return em.createQuery(queryJpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Produto> buscarPelaCategoria(String nome) {
		String queryJpql = "SELECT P FROM Produto P WHERE P.categoria.nome = :nome";
		return em.createQuery(queryJpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<BigDecimal> buscarPrecoPeloNome(String nome) {
		String queryJpql = "SELECT P.preco FROM Produto P WHERE P.nome = :nome";
		return em.createQuery(queryJpql, BigDecimal.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Produto> buscarPorParametros(String nome, LocalDate data){
		String jpql = "Select P"
				+ " from Produto P"
				+ " where P.nome like '%'||:nome||'%'"
				+ " and P.data_insercao between coalesce(:data, to_date('01/01/2000', 'dd/MM/yyyy')) and coalesce(:data, to_date('31/12/2100', 'dd/MM/yyyy'))";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.setParameter("data", data)
				.getResultList();
	}
}
