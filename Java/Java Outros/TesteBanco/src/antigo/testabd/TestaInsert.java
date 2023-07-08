package antigo.testabd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaInsert {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connection = new ConnectionFactory();
		Connection conexao = connection.criaConexao();
		PreparedStatement pstm = conexao.prepareStatement("insert into ti_teste (nome, descricao) values ('MATHEUS', 'MATHEUS SILVA')");
		pstm.execute();
		System.out.println("Foram inseridas " + pstm.getUpdateCount() + " linhas!");
		
	}
}
