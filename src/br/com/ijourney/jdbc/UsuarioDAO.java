package br.com.ijourney.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.ijourney.entidades.Usuario;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDAO {

	private Connection con = (Connection) Conexao.getConnection();

	public void cadastrar(Usuario usuario) {

		String sql = "INSERT  INTO usuarios (nome,login,senha) values(?,?,?)";

		try {
			PreparedStatement preparador = (PreparedStatement) con
					.clientPrepareStatement(sql);

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());

			preparador.execute();

			preparador.close();

			System.out.println("Usuario Cadastrado");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}// End Method

	public void alterar(Usuario usuario) {

		String sql = "UPDATE usuarios SET nome=? , login=? , senha=?  WHERE id= ? ";

		try {
			PreparedStatement preparador = (PreparedStatement) con
					.clientPrepareStatement(sql);

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());

			preparador.execute();

			preparador.close();

			System.out.println("Alterado com sucesso!");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Alteração FALHOU" + e.getMessage());
		}

	}// End Method

	public void ecluir(Usuario usuario) {

		String sql = "DELETE FROM usuarios   WHERE id= ? ";

		try {
			PreparedStatement preparador = (PreparedStatement) con
					.clientPrepareStatement(sql);

			preparador.setInt(1, usuario.getId());

			preparador.execute();

			preparador.close();

			System.out.println("Excluido com sucesso!");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("A EXLUSÁO FALHOU" + e.getMessage());
		}

	}// End Method

	public List<Usuario> buscarTodos() {

		Usuario u = new Usuario();

		List<Usuario> lista = new ArrayList<Usuario>();

		// Monta SQL
		String sql = "SELECT * FROM usuarios";

		try {
			PreparedStatement preparador = (PreparedStatement) con
					.prepareStatement(sql);

			ResultSet r = preparador.executeQuery();

			while (r.next()) {

				u.setNome(r.getString("nome"));
				u.setLogin(r.getString("login"));
				
				//System.out.println( u.getNome()  );

				lista.add(u);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Recuperação da lista de USUÁRIOS FALHOU "
					+ e.getMessage());
		}

		return lista;

	}// end method

}// end class
