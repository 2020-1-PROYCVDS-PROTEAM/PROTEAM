package edu.eci.cvds.samples.Services.impl;

import java.sql.Date;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.entities.Voto;
import edu.eci.cvds.samples.entities.PalabraClave;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.ComentarioDAO;
import edu.eci.cvds.samples.persistence.VotoDAO;
import edu.eci.cvds.samples.persistence.PalabraClaveDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;

@Singleton
public class ServicioProteamImpl implements ServicioProteam {

    @Inject
    private UsuarioDAO daoUsuario;
    @Inject
    private IniciativaDAO daoIniciativa;
    @Inject
    private ComentarioDAO daoComentario;
    @Inject
    private VotoDAO daoVoto;
    @Inject
    private PalabraClaveDAO daoPalabraClave;

    @Override
    public Usuario consultarUsuario(String usuario) throws ServicesException {
        try {
            Usuario u = daoUsuario.consultarUsuario(usuario);
            if (u == null) {
                throw new ServicesException("El usuario no existe");
            } else {
                return u;
            }

        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible consultar el usuario ", ex);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ServicesException {
        try {
            return daoUsuario.consultarUsuarios();
        } catch (PersistenceException ex) {
            throw new ServicesException("No existen usuarios", ex);
        }
    }
    
    @Override
    public List<Iniciativa> consultarIniciativasPalabraClave(String palabraclave) throws ServicesException{
        try{
            return daoIniciativa.consultarIniciativasPalabraClave(palabraclave);
        }catch(PersistenceException ex){
            throw new ServicesException("No fue posible consultar las palabras clave", ex);
        }
    }

    @Override
    public Iniciativa palabraClaveIniciativa(String palabraclave) throws ServicesException {
        try {
            return daoIniciativa.palabraClaveIniciativa(palabraclave);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible consultar la palabra clave", ex);
        }
    }

    @Override
    public Iniciativa consultarIniciativa(int id) throws ServicesException {
        try {
            return daoIniciativa.consultarIniciativa(id);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible consultar la iniciativa", ex);
        }
    }

    @Override
    public List<Iniciativa> consultarIniciativas() throws ServicesException {
        try {
            //System.out.println("ServicioProTeamIMPL INICIATIVA");
            return daoIniciativa.consultarIniciativas();
        } catch (PersistenceException ex) {
            throw new ServicesException("No hay iniciativas", ex);
        }
    }

    @Override
    public Comentario consultarComentario(int id, String idUsuario, int idIniciativa) throws ServicesException {
        try {
            //System.out.println("ServicioProTeamIMPL COMENTARIO");
            return daoComentario.consultarComentario(id, idUsuario, idIniciativa);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible consultar el comentario.", ex);
        }
    }

    @Override
    public List<Comentario> consultarComentarios() throws ServicesException {
        try {
            //System.out.println("ServicioProTeamIMPLCONSULTAR COMENTARIOOS");
            return daoComentario.consultarComentarios();
        } catch (PersistenceException ex) {
            throw new ServicesException("No hay comentarios", ex);
        }
    }

    @Override
    public List<Comentario> consultarComentariosIniciativa(int idIniciativa) throws ServicesException {
        try {
            //System.out.println("ServicioProTeamIMPLCONSULTAR COMENTARIOOSIniciativa");
            return daoComentario.consultarComentariosIniciativa(idIniciativa);
        } catch (PersistenceException ex) {
            throw new ServicesException("No hay comentarios", ex);//en la iniciativa
        }
    }

    @Override
    public void insertIniciativa(int id, int votos, String palabraClave, String nombre, String estado, String descripcion, String area, String usuario_i, String correo_i, Date fechar_ini) throws ServicesException {
        try {
            System.out.println("insertarIniciativaServiciosProTeam");
            System.out.println("id: " + id);
            System.out.println("votos: " + votos);
            System.out.println("palabraClave: " + palabraClave);
            System.out.println("nombre: " + nombre);
            System.out.println("estado: " + estado);
            System.out.println("descripcion: " + descripcion);
            System.out.println("area: " + area);
            System.out.println("usuario_i: " + usuario_i);
            System.out.println("correo_i: " + correo_i);
            System.out.println("ferchar_ini: " + fechar_ini);

            daoIniciativa.insertIniciativa(id, votos, palabraClave, nombre, estado, descripcion, area, usuario_i, correo_i, fechar_ini);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible agregar la nueva iniciativa", ex);
        }
    }

    @Override
    public void registrarUsuario(String usuario, String passwd, String nombre, String apellido, String correo, String rol) throws ServicesException {
        try {
            System.out.println("RegistrarUsuarioServiciosProTeam");
            System.out.println("usuario: " + usuario);
            System.out.println("passwd: " + passwd);
            System.out.println("nombre: " + nombre);
            System.out.println("apellido: " + apellido);
            System.out.println("correo: " + correo);
            System.out.println("correo: " + rol);
            daoUsuario.registrarUsuario(usuario, passwd, nombre, apellido, correo, rol);
        } catch (PersistenceException ex) {
        }
    }

    @Override
    public void cambiarEstado(int id, String estado) throws ServicesException {
        try {
            daoIniciativa.cambiarEstado(id, estado);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible cambiar el estado", ex);
        }
    }

    @Override
    public void cambiarRol(String usuario, String rol) throws ServicesException {
        try {
            System.out.println("ENTRA EN SERVICIOSPT CAMBIARROL");
            daoUsuario.cambiarRol(usuario, rol);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible modificar el rol", ex);
        }
    }

    @Override
    public void insertarComentario(int id, String idUsuario, int idIniciativa, String contenido, Date fecha) throws ServicesException {
        try {
            System.out.println("insertarComentario en serviciosProTeamImpl");
            System.out.println("id: " + id);
            System.out.println("idUsuario: " + idUsuario);
            System.out.println("idIniciativa: " + idIniciativa);
            System.out.println("contenido: " + contenido);
            System.out.println("fecha: " + fecha);

            daoComentario.insertarComentario(id, idUsuario, idIniciativa, contenido, fecha);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible agregar el nuevo comentario", ex);
        }
    }

    @Override
    public void cambiarComentario(int id, String idUsuario, int idIniciativa, String contenido) throws ServicesException {
        try {
            System.out.println("ENTRA EN SERVICIOSPT CambiarComentario");
            daoComentario.cambiarComentario(id, idUsuario, idIniciativa, contenido);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible cambiar el comentario", ex);
        }
    }

    @Override
    public Voto consultarVoto(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            System.out.println("ServicioProTeamIMPL VOTO");
            return daoVoto.consultarVoto(idUsuario, idIniciativa);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible consultar el voto.", ex);
        }
    }

    @Override
    public List<Voto> consultarVotos() throws ServicesException {
        try {
            System.out.println("ServicioProTeamIMPLCONSULTAR VOTOS");
            return daoVoto.consultarVotos();
        } catch (PersistenceException ex) {
            throw new ServicesException("No hay votos", ex);
        }
    }

    @Override
    public List<Voto> consultarVotosIniciativa(int idIniciativa) throws ServicesException {
        try {
            System.out.println("ServicioProTeamIMPLCONSULTAR VOTOSIniciativa");
            return daoVoto.consultarVotosIniciativa(idIniciativa);
        } catch (PersistenceException ex) {
            throw new ServicesException("No hay votos", ex);//en la iniciativa
        }
    }

    @Override
    public void registrarVoto(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            System.out.println("insertarVoto en serviciosProTeamImpl");
            System.out.println("idUsuario: " + idUsuario);
            System.out.println("idIniciativa: " + idIniciativa);

            daoVoto.registrarVoto(idUsuario, idIniciativa);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible agregar el nuevo voto", ex);
        }
    }

    @Override
    public void borrarVoto(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            System.out.println("ENTRA EN SERVICIOSPT borrarVOto");
            daoVoto.borrarVoto(idUsuario, idIniciativa);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible borrar el voto", ex);
        }
    }

    @Override
    public List<Iniciativa> agrupeIniciativas() throws ServicesException {
        try {
            System.out.println("ENTRA EN SERVICIOSPT Agrupe iniciativas");
            return daoIniciativa.agrupeIniciativas();
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible borrar el voto", ex);
        }
    }

    @Override
    public void insertarPalabraClave(int id, int idIniciativa, String palabraClave) throws ServicesException {
        try {
            System.out.println("insertarPalabraClaveIniciativaServiciosProTeamPROOOOOOO");
            System.out.println("id: " + id);
            System.out.println("IdIniciatva: " + idIniciativa);
            System.out.println("palabraClave: " + palabraClave);

            daoIniciativa.insertarPalabraClave(id, idIniciativa, palabraClave);
        } catch (PersistenceException ex) {
            System.out.println("Se atrapo en insertarPalabraClaveSPT");
            throw new ServicesException("No fue posible agregar la nueva palabra clave", ex);
        }
    }

    @Override
    public void relacionarIniciativas(String id1, String id2) throws ServicesException {
        try {
            daoIniciativa.relacionarIniciativas(id1, id2);
        } catch (PersistenceException ex) {
            throw new ServicesException("No fue posible agregar la nueva palabra clave", ex);
        }

    }

    @Override
    public List<Iniciativa> consultarIniciativasRelacionadas(String id) throws ServicesException {
        try {
            return daoIniciativa.consultarIniciativasRelacionadas(id);
        } catch (PersistenceException ex) {
            System.out.println("Esta entrando aca JOSE IMPL");
            throw new ServicesException("No fue posible consultar las iniciativas relacionadas", ex);
        }
    }

    @Override
    public List<PalabraClave> consultarPalabrasClaveIniciativa(int idIniciativa) throws ServicesException {
        try {
            System.out.println("Avanza por SERVICIOSPROTEAM consultarPalabrasclave");
            return daoPalabraClave.consultarPalabrasClaveIniciativa(idIniciativa);
        } catch (PersistenceException e) {
            System.out.println("Esta entrando ServicioIMPL ConsultarPalabraClave");
            throw new ServicesException("No fue posible consultar las palabras claves de la iniciativa", e);
        }

    }
    
    @Override
    public List<Iniciativa> consultarIniciativaPorEstado(String estado) throws ServicesException{
    	try {
    		return daoIniciativa.consultarIniciativaPorEstado(estado);
    	}catch(PersistenceException ex) {
    		throw new ServicesException("No fue posible consultar las iniciativas con ese estado", ex);
    	}
    }
    
    @Override
    public void modificarIniciativa(int id,String descripcion, String estado) throws ServicesException{
    	try {
    		daoIniciativa.modificarIniciativa(id, descripcion, estado);
    	}catch(PersistenceException ex) {
    		throw new ServicesException("No fue posible modificar la iniciativa", ex);
    	}
    }

}
