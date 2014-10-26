package br.com.ijourney.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.ijourney.entidades.Usuario;
import br.com.ijourney.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {

		//Usuario u = new Usuario();
		//u.setId(5);
		//u.setNome("Angela Cardoso");
		//u.setLogin("angelaCardoso@gmail.com");
		//u.setSenha("sall13");

		//testCadastrar(u);
			
		//testExcluir( u );
		
		testeBuscarTodos();

	}

	private static void testCadastrar(Usuario u) {

		UsuarioDAO udao = new UsuarioDAO();

		udao.cadastrar(u);
	}// end method

	private static void testAlterar(Usuario u) {

		UsuarioDAO udao = new UsuarioDAO();

		udao.alterar(u);
	} 
	
	
	private static void testExcluir( Usuario u )  { 
		UsuarioDAO udao = new UsuarioDAO() ;
				
	    udao.ecluir(u) ;			
	}
	
	private static void testeBuscarTodos(){
		
		UsuarioDAO udao = new UsuarioDAO() ;
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) udao.buscarTodos(); 
		
		//ArrayList<String> teste = new ArrayList<String>() ;
		
		//teste.add("Jazz") ;
		//teste.add("Rock") ;
		
		for( Usuario u : usuarios ){
			
			System.out.println( u.getNome()   );
			
		}
		
	}
  

}
