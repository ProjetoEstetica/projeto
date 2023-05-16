package br.com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/clientes";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}

	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		
		if (con != null) {
			System.out.println("Conexão obetida com sucesso!");
			con.close();
		}
	}
}
