package br.com.ijourney.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection getConnection() {

		Connection con = null;

		try {

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ijourney", "root", "");
			System.out.println("Sucesso na Conex�o");

		} catch (Exception e) {
			System.out.println("  N�o funfou    " + e.getMessage());
		}// end try

		return con;

	}// End Method

} // End Class
