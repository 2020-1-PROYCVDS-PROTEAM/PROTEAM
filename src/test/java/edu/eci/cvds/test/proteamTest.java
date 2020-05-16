package edu.eci.cvds.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import com.google.inject.Inject;

import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;
import edu.eci.cvds.samples.Services.ServicioProteamFactory;
//import edu.eci.cvds.samples.persistence.PersistenceException;

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
            sp.consultarUsuario("JoseTest");
        } catch (ServicesException ex) {
            fail();
        }
    }

    @Test
    public void deberiaConsultarTodosLosUsuariosRegistrados() {
        try {
            sp.consultarUsuarios();
        } catch (ServicesException ex) {
            fail();
        }

    }

    @Test
    public void lanzaExcepcionNoExisteUsuario() {
        try {
            sp.consultarUsuario("noConocido");
            fail();
        } catch (ServicesException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void realizaConsultaDeUsuario() {
        try {
            sp.consultarUsuario("eduardj");
        } catch (ServicesException ex) {
            fail();
        }
    }

    


    @Test
    public void realizaConsultaDeIniciativas() {
        try {
            sp.consultarIniciativas();
        } catch (ServicesException ex) {
            fail();
        }
    }

    @Test
    public void consultarIniciativaPorIdentificador() {
        try {
            sp.consultarIniciativa(1);
        } catch (ServicesException ex) {
            fail();
        }
    }

    @Test
    public void deberiaDarExcepcionNoExisteIniciativa() {
        try {
            sp.consultarIniciativa(2130184);
            fail();
        } catch (ServicesException ex) {

        }
    }

    @Test
    public void consultaIniciativasPorPalabraClave() {
        try {
            sp.palabraClaveIniciativa("Seguridad");
        } catch (ServicesException ex) {
            fail();
        }
    }

    @Test
    public void deberíaLanzarExcepcionPalabraClave() {
        try {
            sp.palabraClaveIniciativa("Esta palabra no existe");
            
        } catch (ServicesException ex) {

        }
    }

    @Test
    public void deberiaConsultarIniciativasRelacionadas() {
        try {
            sp.consultarIniciativasRelacionadas("SEGIPRO");
        } catch (ServicesException ex) {
            fail();
        }
    }

 

    @Test
    public void noDeberiaConsultarIniciativasPorEstadoNoExiste() {
        try {
            sp.consultarIniciativaPorEstado("43235234");
            fail();
        } catch (ServicesException ex) {

        }
    }



    @Test
    public void noDeberiaModificarIniciativaPorSuEstado() {
        try {
            sp.modificarIniciativa(6, "Enseñando java");
            fail();
        } catch (ServicesException ex) {

        }
    }

    @Test
    public void deberiaConsultarIniciativasPorUsuario() {
        try {
            sp.consultarIniciativasProponente("eduardj");

        } catch (ServicesException ex) {
            fail();
        }
    }

    @Test
    public void noDeberiaConsultarIniciativasPorUsuarioNoExiste() {
        try {
            sp.consultarIniciativasProponente("Usuario que no existe");
            fail();
        } catch (ServicesException ex) {

        }
    }

    @Test
    public void prueba() {
        try {
            sp.agrupeEstados();
        } catch (ServicesException ex) {
            fail();
        }
    }

}
