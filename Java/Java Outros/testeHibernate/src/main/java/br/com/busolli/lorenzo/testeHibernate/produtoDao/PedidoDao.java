package br.com.busolli.lorenzo.testeHibernate.produtoDao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.busolli.lorenzo.testeHibernate.modelo.Pedido;
import br.com.busolli.lorenzo.testeHibernate.vo.RelatorioDeVendasVO;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal getValorTotalDeVenda() {
		String jpql = "select sum(p.valorTotal) from Pedido p";
		return em.createQuery(jpql, BigDecimal.class)
		       .getSingleResult();
	}
	
	public List<RelatorioDeVendasVO> getRelatorioDeVendas(){
		String jpql = "SELECT new br.com.busolli.lorenzo.testeHibernate.vo.RelatorioDeVendasVO("
				+ "           produto.nome"
				+ "          ,sum(itensPedido.quantidade)"
				+ "          ,max(pedido.data))"
				+ "      FROM Produto produto"
				+ "          ,ItensPedido itensPedido"
				+ "          ,Pedido pedido"
				+ "     WHERE pedido.id = itensPedido.pedido"
				+ "       AND produto.id = itensPedido.produto"
				+ "  GROUP BY produto.nome";
		return em.createQuery(jpql, RelatorioDeVendasVO.class).getResultList();
	}
	
	public Pedido buscarPorId(long id) {
		String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id";
		return em.createQuery(jpql, Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}

}
