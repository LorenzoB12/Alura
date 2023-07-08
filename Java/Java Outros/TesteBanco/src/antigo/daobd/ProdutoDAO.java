package antigo.daobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import antigo.modelo.Categoria;
import antigo.modelo.Produto;

public class ProdutoDAO {

	private Connection conexao;

	public ProdutoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void salvar(Produto produto) throws SQLException {
		
		String sql = "insert into ti_teste (nome, descricao) values (?, ?)";
		
		try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.execute();

		}
		
		System.out.println(produto);
		
	}
	
	public List<Produto> lista() throws SQLException{
		String sql = "select * from ti_teste";
		List<Produto> produtos = new ArrayList<>();
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
					produtos.add(produto);
				}
			}
		}
		
		return produtos;
	}

	public List<Produto> buscar(Categoria categoria) throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from ti_teste where categoria = ?";
		
		try(PreparedStatement pstm = conexao.prepareStatement(sql)){
			pstm.setInt(1, categoria.getId());
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto prod = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
					produtos.add(prod);
				}
			}
		}
		return produtos;
	}

}










