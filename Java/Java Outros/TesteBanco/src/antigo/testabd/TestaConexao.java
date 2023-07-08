package antigo.testabd;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conn = new ConnectionFactory();
		
		for(int i = 1; i < 20; i++) {
			Connection conexao = conn.criaConexao();
			System.out.println("Conexao numero " + i);
		}
	}

}
