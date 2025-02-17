package edu.udelp.orientada_objetos.foro.process;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.udelp.orientada_objetos.foro.Usuario;

class UsuarioProcessTest {

	@Test
	void testRegistrar() {
		Usuario u=new Usuario();
		UsuarioProcess us=new UsuarioProcess();
		
		us.registrar();
		
		
	}

	@Test
	void testValidarEmail() {
		fail("Not yet implemented");
	}

	@Test
	void testEmailExiste() {
		fail("Not yet implemented");
	}

	@Test
	void testValidarNombre() {
		fail("Not yet implemented");
	}

	@Test
	void testValidarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testUsuarioExiste() {
		fail("Not yet implemented");
	}

	@Test
	void testValidarPassword() {
		fail("Not yet implemented");
	}

	@Test
	void testEditar() {
		fail("Not yet implemented");
	}

	@Test
	void testDarBaja() {
		fail("Not yet implemented");
	}

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	void testFollow() {
		fail("Not yet implemented");
	}

	@Test
	void testUnfollow() {
		fail("Not yet implemented");
	}

	@Test
	void testBloquear() {
		fail("Not yet implemented");
	}

}
