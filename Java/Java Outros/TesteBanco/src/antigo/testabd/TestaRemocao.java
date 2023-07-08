package antigo.testabd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connection = new ConnectionFactory();
		Connection conexao = connection.criaConexao();
		
		PreparedStatement stm = conexao.prepareStatement("delete from ti_teste where cod_id > ?");
		stm.setInt(1, 3);
		stm.execute();
		Integer cont = stm.getUpdateCount();
		
		System.out.println("Foram deletadas " + cont + " linhas!");
	}

}
