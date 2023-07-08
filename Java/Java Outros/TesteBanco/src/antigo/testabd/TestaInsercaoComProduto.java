package antigo.testabd;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import antigo.daobd.ProdutoDAO;
import antigo.modelo.Produto;

public class TestaInsercaoComProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto armario = new Produto("Armario", "Armario 3 portas casal");
		
		try(Connection conexao = new ConnectionFactory().criaConexao()){
			ProdutoDAO produtoDao = new ProdutoDAO(conexao);
			produtoDao.salvar(armario);
			List<Produto> lista = produtoDao.lista();
			lista.forEach(produto -> System.out.println(produto));
		}
	}
}
