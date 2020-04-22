package edu.eci.cvds.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;
import edu.eci.cvds.samples.Services.ServicioProteamFactory;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;

import org.apache.ibatis.session.SqlSession;

public class proteamTest {
    
	@Inject
    private SqlSession sqlSession;
    ServicioProteam sp;
    
    
    public proteamTest() {
    	sp = ServicioProteamFactory.getInstance().getServicioProteam();
    }
    
	@Test
    public void deberiaConsultarUsuario() {
		try {
			Usuario u = sp.consultarUsuario("cesarg");
		}catch(ServicesException ex) {
			fail();
		}
    }
	
	@Test
	public void deberiaConsultarTodosLosUsuariosRegistrados() {
		try {
			List<Usuario> us = sp.consultarUsuarios();
			
		}catch(ServicesException ex) {
			fail();
		}
		
	}
	
	@Test
    public void lanzaExcepcionNoExisteUsuario() {
    	try {
    		Usuario u = sp.consultarUsuario("noConocido");
    		assertTrue(false);
    	}catch(ServicesException ex) {
    		assertTrue(true);
    	}
    }
	
	@Test
    public void realizaConsultaDeUsuario() {
		try {
			Usuario u = sp.consultarUsuario("eduardj");
		}catch(ServicesException ex) {
			fail();
		}
    }
	
	
 
}