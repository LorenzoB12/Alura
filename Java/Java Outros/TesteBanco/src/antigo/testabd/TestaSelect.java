package antigo.testabd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaSelect {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connection = new ConnectionFactory();
		Connection conexao = connection.criaConexao();
		PreparedStatement pstm = conexao.prepareStatement("select cod_pessoa, des_pessoa, des_fantasia from ps_pessoas where cod_pessoa < ?");
		pstm.setInt(1, 115);
		pstm.execute();
		
		ResultSet resultado = pstm.getResultSet();
		
		while(resultado.next()) {
			Integer id = resultado.getInt("cod_pessoa");
			System.out.print(id + " - ");
			String nome = resultado.getString("des_pessoa");
			System.out.print(nome + " - ");
			String nomeFant = resultado.getString("des_fantasia");
			System.out.print(nomeFant);
			System.out.println();
		}
		
		conexao.close();
		
	}

}
