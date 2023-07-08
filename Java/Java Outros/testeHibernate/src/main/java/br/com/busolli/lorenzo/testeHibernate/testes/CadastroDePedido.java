package br.com.busolli.lorenzo.testeHibernate.testes;

import javax.persistence.EntityManager;

import br.com.busolli.lorenzo.testeHibernate.modelo.Livro;
import br.com.busolli.lorenzo.testeHibernate.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		/*ProdutoDao produtoDao = new ProdutoDao(em);
		List<Produto> prod = produtoDao.buscarTodos();
		//prod.forEach(produ -> System.out.println(produ.getNome()));
		Produto produto = produtoDao.buscarPorId(14);
		Cliente cliente = new Cliente("Matheus", "999988988");
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		Pedido pedido = new Pedido(cliente);
		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
		
		ItensPedido itPed = new ItensPedido(1l, produto, pedido);
		em.getTransaction().begin();
		em.persist(itPed);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		pedido = em.merge(pedido);
		pedido.adicionarItem(itPed);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		pedido = em.merge(pedido);*/
		
		/*PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.getRelatorioDeVendas().forEach(System.out::println);
		Pedido pe2 = pedidoDao.buscarPorId(11l);
		em.close();
		System.out.println(pe2.getCliente().getNome());*/
		
		/*ProdutoDao produtoDao = new ProdutoDao(em);*/
		/*List<Produto> prod = produtoDao.buscarPorParametros("1", LocalDate.now());
		prod.forEach(p -> System.out.println(p));*/
		
		/*Cliente cliente = new Cliente(new DadosPessoais("Matheus", "999988988"));
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		Produto prod = produtoDao.buscarPorId(1);
		System.out.println(prod.getDescricao());*/
		
		Livro livro = new Livro("Lorenzo", 20, 1);
		
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
		
		
		
	}

}
