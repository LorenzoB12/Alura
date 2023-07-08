package antigo.testabd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametros {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connection = new ConnectionFactory();

		try (Connection conexao = connection.criaConexao()) {
			conexao.setAutoCommit(false);

			try (PreparedStatement pstm = conexao.prepareStatement(
					"insert into ti_teste (nome, descricao) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				insertBanco("Super", "Max", pstm);
				insertBanco("Luis", "Suarez", pstm);
				conexao.commit();

			} catch (Exception e) {
				e.printStackTrace();
				conexao.rollback();
				System.out.println("ROLLBACK EXECUTADO!");

			}
		}
	}

	private static void insertBanco(String nome, String descricao, PreparedStatement pstm) throws SQLException {
		pstm.setString(1, nome);
		pstm.setString(2, descricao);
		pstm.execute();

//		if(nome.equals("Luis")) {
//			throw new RuntimeException();
//		}

		System.out.println("Linhas inseridas: " + pstm.getLargeUpdateCount());
	}

}
