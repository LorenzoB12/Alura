package br.com.busolli.lorenzo.gerenciador.bd;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource pds = new ComboPooledDataSource();
		pds.setJdbcUrl("jdbc:oracle:thin:@192.168.200.6:1521:orcl");
		pds.setUser("nlteste");
		pds.setPassword("nlteste");
		pds.setMaxPoolSize(5);
		this.dataSource = pds;
	}

	public Connection criaConexao() throws SQLException {
		return this.dataSource.getConnection();
	}
	
}
