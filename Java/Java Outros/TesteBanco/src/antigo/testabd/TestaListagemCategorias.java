package antigo.testabd;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import antigo.daobd.CategoriaDAO;
import antigo.daobd.ProdutoDAO;
import antigo.modelo.Categoria;
import antigo.modelo.Produto;

public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().criaConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> lista = categoriaDao.buscar();
			lista.forEach(categoria ->

			{
				System.out.println("--------" + categoria.getNome() + "--------");
				for (Produto prod : categoria.getProduto()) {
					System.out.println(categoria.getNome() + " -> " + prod.getNome());
				}
				;

			}

			);
		}

	}

}
