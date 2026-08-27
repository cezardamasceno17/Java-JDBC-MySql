package br.com.projeto.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToMySql {
	private static final String USER = "root";
	private static final String PASS = "83236668";
	private static final String URL = "jdbc:mysql://localhost:3306/clientes";
	
	public static Connection connectionMySql() throws Exception{
		Connection conn = DriverManager.getConnection(URL,USER,PASS);
		return conn;
	}
	
	public static void main(String[] args) throws Exception{
		Connection conn = connectionMySql();
		
		if(conn != null) {
			System.out.println("Conexão adquirida");
		}
		
	}
}
