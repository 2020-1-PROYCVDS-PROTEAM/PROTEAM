package edu.eci.cvds.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;
import edu.eci.cvds.samples.Services.ServicioProteamFactory;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.entities.Voto;
import edu.eci.cvds.samples.entities.PalabraClave;
import edu.eci.cvds.samples.persistence.PersistenceException;

import org.apache.ibatis.session.SqlSession;

public class proteamTest {
    
	@Inject
    private SqlSession sqlSession;
    ServicioProteam sp;
    
    
    public proteamTest() {
    	sp = ServicioProteamFactory.getInstance().getServicioProteam();
    }

	/*
	@Test
    public void deberiaConsultarUsuario() {
		try {
			Usuario u = sp.consultarUsuario("cesarg");
		}catch(ServicesException ex) {
			fail();
		}
    }*/
	/*
	@Test
	public void deberiaConsultarTodosLosUsuariosRegistrados() {
		try {
			List<Usuario> us = sp.consultarUsuarios();
			
		}catch(ServicesException ex) {
			fail();
		}
		
	}*/

	/*
	@Test
    public void lanzaExcepcionNoExisteUsuario() {
    	try {
    		Usuario u = sp.consultarUsuario("noConocido");
    		fail();
    	}catch(ServicesException ex) {
    		assertTrue(true);
    	}
    }
	*/

	/*
	@Test
    public void realizaConsultaDeUsuario() {
		try {
			Usuario u = sp.consultarUsuario("eduardj");
		}catch(ServicesException ex) {
			fail();
		}
    }*/
	
	/*
	@Test
    public void deberiaRegistrarUsuario() {
		try {
			sp.registrarUsuario("JoseTest","GM123","Jose","Gutierrez","test@gmail.com","Publico");
			sp.consultarUsuario("JoseTest");
			
		}catch(ServicesException ex) {
			fail();
		}
    }
	
	
    @Test
    public void realizaConsultaDeIniciativas() {
		try {
			List<Iniciativa> i = sp.consultarIniciativas();
		}catch(ServicesException ex) {
			fail();
		}
    }
    */
	
	/*
	@Test
	public void consultarIniciativaPorIdentificador() {
		try {
			Iniciativa i = sp.consultarIniciativa(1);
		}catch(ServicesException ex) {
			fail();
		}
	}
	*/
	
    /*
	@Test
	public void deberiaDarExcepcionNoExisteIniciativa() {
		try {
			Iniciativa i = sp.consultarIniciativa(2130184);
			fail();
		}catch(ServicesException ex) {
			
		}
	}*/
	
	
	/*@Test
	public void consultaIniciativasPorPalabraClave() {
		try {
			Iniciativa i = sp.palabraClaveIniciativa("Seguridad");
			
		}catch(ServicesException ex) {
			fail();
		}
	}
	
	
	@Test
	public void deberíaLanzarExcepcionPalabraClave() {
		try {
			Iniciativa i = sp.palabraClaveIniciativa("Esta palabra no existe");
			fail();
		}catch(ServicesException ex) {
			
		}
	}*/

	/*
	@Test
	public void deberiaConsultarIniciativasRelacionadas() {
		try {
			List<Iniciativa> i = sp.consultarIniciativasRelacionadas(1);
		}catch(ServicesException ex) {
			fail();
		}
	}*/
    
	@Test
	public void deberiaConsultarIniciativasPorEstado() {
		try {
			List<Iniciativa> i = sp.consultarIniciativaPorEstado("Proyecto");
			Iniciativa s  = sp.consultarIniciativa(5);
		}catch(ServicesException ex) {
			fail();
		}
	}
	
	@Test
	public void noDeberiaConsultarIniciativasPorEstadoNoExiste() {
		try {
			List<Iniciativa> i = sp.consultarIniciativaPorEstado("43235234");
			fail();
		}catch(ServicesException ex) {
			
		}
	}
	
	@Test
	public void deberiaModificarIniciativaPorSuEstado() {
		try {
			sp.modificarIniciativa(5, "Enseñando java", "En espera de revisión");
		}catch(ServicesException ex) {
			fail();
		}
	}
	
	@Test
	public void noDeberiaModificarIniciativaPorSuEstado() {
		try {
			sp.modificarIniciativa(6, "Enseñando java", "En espera de revisión");
			fail();
		}catch(ServicesException ex) {

		}
	}
	
	
}