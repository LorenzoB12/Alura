package br.com.busolli.lorenzo.testeHibernate.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.busolli.lorenzo.testeHibernate.modelo.Categoria;
import br.com.busolli.lorenzo.testeHibernate.modelo.Produto;
import br.com.busolli.lorenzo.testeHibernate.produtoDao.CategoriaDao;
import br.com.busolli.lorenzo.testeHibernate.produtoDao.ProdutoDao;
import br.com.busolli.lorenzo.testeHibernate.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		//CadastroProdutos();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		List<Produto> p2 = produtoDao.buscarPelaCategoria("CELULARES");
		p2.forEach(p -> System.out.println(p.getNome() + " " + p.getDescricao()));
		
		List<BigDecimal> bd = produtoDao.buscarPrecoPeloNome("Xiaomi MI9T Pro");
		bd.forEach(preco -> System.out.println("Preco do produto: " + preco));
	}

	private static void CadastroProdutos() {
		Categoria categoria = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi MI9T Pro2", "Meu celular", new BigDecimal("2000"), categoria);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);		
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(categoria);
		produtoDao.cadastrar(celular);
		em.clear();
		produtoDao.atualizar(celular);
		celular.setDescricao("Celular");
		em.getTransaction().commit();
		em.close();
	}
}
