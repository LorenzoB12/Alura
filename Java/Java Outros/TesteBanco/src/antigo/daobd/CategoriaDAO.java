package antigo.daobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import antigo.modelo.Categoria;
import antigo.modelo.Produto;

public class CategoriaDAO {

	private Connection conexao;

	public CategoriaDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "select * from ti_teste_categoria";

		try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {

				while (rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Categoria> buscar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "select * from ti_teste_categoria c inner join ti_teste p on c.id = p.categoria order by 2";
		Categoria ultima = null;

		try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				if (ultima == null || !ultima.getNome().equals(rst.getString(2))) {

					while (rst.next()) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2),
								new Produto(rst.getInt(3), rst.getString(4), rst.getString(5)));
						categorias.add(categoria);
						ultima = categoria;
					}
				}
			}
		}
		return categorias;
	}

}
